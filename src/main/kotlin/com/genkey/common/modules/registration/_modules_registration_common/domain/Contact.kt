package com.genkey.common.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IContact
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IIdContact

/*
CREATE TABLE public.contacts_profiles (
	id uuid NOT NULL,
	contact_type varchar(32) NOT NULL,
	contact_info varchar(128) NOT NULL,
	is_primary bool NOT NULL,
	is_active bool DEFAULT true NULL,
	subject_id uuid NOT NULL,
	spire_transaction_id uuid NOT NULL,
	CONSTRAINT pk_contacts_profiles PRIMARY KEY (id),
	CONSTRAINT fk_contacts_profiles_spire_transactions FOREIGN KEY (spire_transaction_id) REFERENCES public.spire_transactions(id),
	CONSTRAINT fk_contacts_profiles_subjects FOREIGN KEY (subject_id) REFERENCES public.subjects(id)
);
 */

/**
 * SubjectId is removed, since this class's belonging to a subject is expressed in another way.
 * "id" is here just for update when this object is to be written to the exactly same row in the dbase.
 * In case of creation of a new object, the id is assigned a 'UUID.UNASSIGNED' value, since that object
 * has never been in the dbase.
 */

open class Contact(
    override val id: UUID,
    override val contactType: IContact.ContactType,
    override val contactInfo: String,
    override val isPrimary: Boolean
): IIdContact
