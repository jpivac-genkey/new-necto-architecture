package com.genkey.common.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.fingerprints._module_fingerprints_common.FingerPrintsCommonAPI

/*

CREATE TABLE public.fingerprints_profiles (
	id uuid NOT NULL,
	bio_hash bytea NULL,
	subject_id uuid NOT NULL,
	spire_transaction_id uuid NOT NULL,
	CONSTRAINT pk_fingerprints_profiles PRIMARY KEY (id),
	CONSTRAINT fk_fingerprints_profiles_spire_transactions FOREIGN KEY (spire_transaction_id) REFERENCES public.spire_transactions(id),
	CONSTRAINT fk_fingerprints_profiles_subjects FOREIGN KEY (subject_id) REFERENCES public.subjects(id)
);
 */
/**
 * SubjectId is removed, since this class's belonging to a subject is expressed in another way.
 * "id" is here just for update when this object is to be written to the exactly same row in the dbase
 * In case of creation of a new object, the id is assigned null value, since that object
 * has never been in the dbase.
 */
abstract class FingerPrintSet(
    val id: UUID? = null
)
{
    open class FingerPrints(id: UUID? = null, override val individualFingers: List<FingerPrint>):
        FingerPrintSet(id), FingerPrintsCommonAPI.IFingerPrints
    {
        //used for receiving the output from FingerPrint Capture  module
        constructor(fingerPrints: FingerPrintsCommonAPI.IFingerPrints):
            this(null, fingerPrints.individualFingers.map { FingerPrint(it) })
    }

    open class BioHashFingerPrints(id: UUID?, val bioHash: ByteArray):
        FingerPrintSet(id)
}