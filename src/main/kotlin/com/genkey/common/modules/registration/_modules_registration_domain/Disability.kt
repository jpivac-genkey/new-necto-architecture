package com.genkey.common.modules.registration._modules_registration_domain

import com.genkey.common.modules.basic.UUID

/*
CREATE TABLE public.disabilities_profiles (
	id uuid NOT NULL,
	disability_type varchar(32) NOT NULL,
	disability_details varchar(128) NULL,
	is_permanent bool DEFAULT true NOT NULL,
	is_active bool DEFAULT true NOT NULL,
	subject_id uuid NOT NULL,
	spire_transaction_id uuid NOT NULL,
	CONSTRAINT pk_disabilities_profiles PRIMARY KEY (id),
	CONSTRAINT fk_disabilities_profiles_spire_transactions FOREIGN KEY (spire_transaction_id) REFERENCES public.spire_transactions(id),
	CONSTRAINT fk_disabilities_profiles_subjects FOREIGN KEY (subject_id) REFERENCES public.subjects(id)
);
 */
/**
 * SubjectId is removed, since this class's belonging to a subject is expressed in another way.
 * "id" is here just for update when this object is to be written to the exactly same row in the dbase.
 * In case of creation of a new object, the id is assigned a 'UUID.UNASSIGNED' value, since that object
 * has never been in the dbase.
 */
class Disability(
    val id: UUID,
    val disabilityType: TraumaType,
    val disabilityDetails: TraumaDetail? = null,
    val isPermanent: Boolean? = true
)
{
    enum class TraumaType
    {
        OTHER, FACIAL, BLIND, MISSING_LIMB, ILLITERATE, UNABLE_TO_SIGN, DEAF, BAD_QUALITY, DUMB, DEAF_AND_DUMB, INCOMPETENT
    }

    enum class TraumaDetail
    {
        TRAUMA_BOTH, TRAUMA_FINGER, TRAUMA_LEFT, TRAUMA_OTHER, TRAUMA_RIGHT,
        TRAUMA_LEFT_HAND, TRAUMA_RIGHT_HAND, TRAUMA_ALL
    }

}
