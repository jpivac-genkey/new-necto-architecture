package com.genkey.common.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IDisability
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IIdDisability

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
    override val id: UUID,
    override val disabilityType: IDisability.TraumaType,
    override val disabilityDetails: IDisability.TraumaDetail? = null,
    override val isPermanent: Boolean? = true
): IIdDisability
