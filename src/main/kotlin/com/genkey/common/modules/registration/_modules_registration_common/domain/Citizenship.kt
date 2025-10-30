package com.genkey.common.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_common.interfaces.ICitizenship
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IIdCitizenship

/*
CREATE TABLE public.citizenship_profiles (
	id uuid NOT NULL,
	document_type varchar(32) NOT NULL,
	document_id varchar(32) NOT NULL,
	country_code varchar(3) NOT NULL,
	nationality varchar(32) NULL,
	is_by_birth bool NOT NULL,
	is_active bool DEFAULT true NULL,
	subject_id uuid NOT NULL,
	spire_transaction_id uuid NOT NULL,
	CONSTRAINT pk_citizenship_profiles PRIMARY KEY (id),
	CONSTRAINT fk_citizenship_profiles_spire_transactions FOREIGN KEY (spire_transaction_id) REFERENCES public.spire_transactions(id),
	CONSTRAINT fk_citizenship_profiles_subjects FOREIGN KEY (subject_id) REFERENCES public.subjects(id)
);
 */
/**
 * SubjectId is removed, since this class's belonging to a subject is expressed in another way.
 * "id" is here just for update when this object is to be written to the exactly same row in the dbase
 * In case of creation of a new object, the id is assigned a 'UUID.UNASSIGNED' value, since that object
 * has never been in the dbase.
 */



class Citizenship(
    override val id: UUID,
    override val documentType: ICitizenship.DocumentType,
    override val documentId: String,
    override val countryCode: ICitizenship.CountryCode,
    override val nationality: ICitizenship.Nationality? = null,
    override val isByBirth: Boolean
): IIdCitizenship

