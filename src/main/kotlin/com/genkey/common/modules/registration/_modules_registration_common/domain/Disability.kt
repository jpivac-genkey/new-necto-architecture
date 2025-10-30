package com.genkey.common.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.basic.ValInterface

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
open class Disability(
    val id: UUID,
    val disabilityType: TraumaType,
    val disabilityDetails: TraumaDetail? = null,
    val isPermanent: Boolean? = true
)
{
    interface TraumaType: ValInterface
    interface TraumaDetail: ValInterface

    enum class TraumaEnum(override val value: Int): TraumaType
    {
        OTHER(1),
        FACIAL(2),
        BLIND(3),
        MISSING_LIMB(4),
        ILLITERATE(5),
        UNABLE_TO_SIGN(6),
        DEAF(7),
        BAD_QUALITY(8),
        DUMB(9),
        DEAF_AND_DUMB(10),
        INCOMPETENT(11)
    }

    enum class TraumaDetailEnum(override val value: Int): TraumaDetail
    {
        TRAUMA_BOTH(1),
        TRAUMA_FINGER(2),
        TRAUMA_LEFT(3),
        TRAUMA_OTHER(4),
        TRAUMA_RIGHT(5),
        TRAUMA_LEFT_HAND(6),
        TRAUMA_RIGHT_HAND(7),
        TRAUMA_ALL(8)
    }

}
