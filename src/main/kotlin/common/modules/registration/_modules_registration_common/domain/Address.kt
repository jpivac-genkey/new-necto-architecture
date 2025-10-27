package com.genkey.common.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.UUID

/*

CREATE TABLE public.addresses_profiles (
	id uuid NOT NULL,
	address_type varchar(32) NOT NULL,
	country varchar(64) NULL,
	region varchar(64) NULL,
	city varchar(64) NULL,
	address varchar(128) NOT NULL,
	address_details varchar(128) NULL,
	postal_code varchar(64) NULL,
	is_active bool DEFAULT true NULL,
	demarcation_entry_id int8 NULL,
	subject_id uuid NOT NULL,
	spire_transaction_id uuid NOT NULL,
	CONSTRAINT pk_addresses_profiles PRIMARY KEY (id),
	CONSTRAINT fk_addresses_profiles_demarcations_entries FOREIGN KEY (demarcation_entry_id) REFERENCES public.demarcations_entries(id),
	CONSTRAINT fk_addresses_profiles_spire_transactions FOREIGN KEY (spire_transaction_id) REFERENCES public.spire_transactions(id),
	CONSTRAINT fk_addresses_profiles_subjects FOREIGN KEY (subject_id) REFERENCES public.subjects(id)
);
 */
/**
 * SubjectId is removed, since this class's belonging to a subject is expressed in another way.
 * "id" is here just for update when this object is to be written to the exactly same row in the dbase
 * In case of creation of a new object, the id is assigned a 'UUID.UNASSIGNED' value, since that object
 * has never been in the dbase.
 */
class Address(
    val id: UUID,
    val addressType: AddressType,
    val country: String? = null,
    val region: String? = null,
    val city: String? = null,
    val address: String,
    val addressDetails: String? = null,
    val postalCode: String? = null,
    val demarcationEntryId: Int? = null
){
    enum class AddressType
    {
        //do we already have the values somewhere in the code?
    }
}
