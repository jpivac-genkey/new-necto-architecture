package com.genkey.common.modules.registration._modules_registration_common.repo.dbase.utils

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_common.domain.FingerPrintSet

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

/*
FingerPrints domain objects are more human-friendly and do not map directly to the dbase table row.
So we introduce this object that maps a row in the "fingerprints_profiles" table.

There are methods for conversions in both directions
  domain object --> DTO object
  DTO object domain --> object

Note that SubjectId is removed, since this class's belonging to a subject is expressed in another way.
 */

class FingerPrintsDTO(
    val id: UUID? = null,
    val bioHash: ByteArray? = null,
    val individualFingers: List<FingerPrintDTO>? = null)
{
    fun toFingerPrints(): FingerPrintSet
    {
        if (individualFingers != null)
        {
            return FingerPrintSet.FingerPrints(id, individualFingers.map { it.toFingerPrint() })
        }
        else
        {
            //biohash must be present
            return FingerPrintSet.BioHashFingerPrints(id, bioHash!!)
        }
    }
}


fun FingerPrintSet.toFingerPrintsDTO() :FingerPrintsDTO
{
    return when(this)
    {
        is FingerPrintSet.FingerPrints ->  FingerPrintsDTO(this.id, null, this.individualFingers.map { it.toFingerPrintDTO() })
        is FingerPrintSet.BioHashFingerPrints-> FingerPrintsDTO(this.id, this.bioHash, null)
        else -> TODO("Impossible to come here")
    }
}