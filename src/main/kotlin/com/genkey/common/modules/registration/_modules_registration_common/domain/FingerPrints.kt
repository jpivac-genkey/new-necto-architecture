package com.genkey.common.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.fingerprints.module_fingerprints_capture_api.FPCaptureAPI

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
 * In case of creation of a new object, the id is assigned a 'UUID.UNASSIGNED' value, since that object
 * has never been in the dbase.
 */
class FingerPrints(
    val id: UUID,
    val bioHash: ByteArray? = null,
    val individualFingers: List<FingerPrint>? = null
)
{
    companion object
    {
        fun createFrom(_fingerPrints: List<FPCaptureAPI.FingerPrint>): FingerPrints
        {
            return FingerPrints(UUID.UNASSIGNED,null, _fingerPrints.map { FingerPrint.createForm(it)})
        }
    }

    fun convert(): List<FPCaptureAPI.FingerPrint>
    {
        return this.individualFingers!!.map { it.convert()}
    }

}