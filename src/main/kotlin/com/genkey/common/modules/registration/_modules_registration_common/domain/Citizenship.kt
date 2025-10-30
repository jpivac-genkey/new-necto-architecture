package com.genkey.common.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.UUID

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
open class Citizenship(
    val id: UUID,
    val documentType: DocumentType,
    val documentId: String,
    val countryCode: CountryCode,
    val nationality: Nationality? = null,
    val isByBirth: Boolean
)
{
    enum class DocumentType{
        //do we already have the values somewhere in the code?
    }

    /*
    For "nationality" and "countryCode" we can use just strings.
    Or to go with enums where we predefine all possible values.
     */
    enum class Nationality{

    }
    enum class CountryCode{
         //we can find the list of international official codes for all countries
    }
}
