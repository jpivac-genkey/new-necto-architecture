package com.genkey.common.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.registration._modules_registration_common.interfaces.*
import java.util.*

/*
CREATE TABLE public.subjects (
	id uuid NOT NULL,
	registration_date timestamptz NOT NULL,
	spire_last_update_date timestamptz NULL,
	external_code varchar(64) NULL,
	eligibility_status varchar(64) NOT NULL,
	identification_number varchar(64) NOT NULL,
	identification_type varchar(64) NOT NULL,
	first_name varchar(64) NOT NULL,
	middle_name varchar(64) NULL,
	last_name varchar(64) NOT NULL,
	last_name_2 varchar(64) NULL,
	gender int2 NOT NULL,
	date_of_birth timestamptz(6) NULL,
	spire_transaction_id uuid NOT NULL,
	CONSTRAINT pk_subjects PRIMARY KEY (id),
	CONSTRAINT fk_subjects_spire_transactions FOREIGN KEY (spire_transaction_id) REFERENCES public.spire_transactions(id)
);
 */

open class Biographics(
    override val identificationNumber: String,
    override val identificationType: String,
    override val externalCode: String? = null,
    override val eligibilityStatus: EligibilityStatus,
    override val firstName: String,
    override val middleName: String? = null,
    override val lastName: String,
    override val lastName2: String? = null,
    override val gender: Gender,
    override val dateOfBirth: Date? = null,
    override val citizenship: IIdCitizenship? = null,
    override val disabilities: List<IIdDisability>? = null,
    override val address: IIdAddress? = null,
    override val contacts: List<IIdContact>? = null
    ): IBiographics
{
        constructor(basicBiographics: IBiographics.IBasicBiographics,
                    citizenship: IIdCitizenship? = null,
                    disabilities: List<IIdDisability>? = null,
                    address: IIdAddress? = null,
                    contacts: List<IIdContact>? = null
            ): this(basicBiographics.identificationNumber,
                    basicBiographics.identificationType,
                    basicBiographics.externalCode,
                    basicBiographics.eligibilityStatus,
                    basicBiographics.firstName,
                    basicBiographics.middleName,
                    basicBiographics.lastName,
                    basicBiographics.lastName2,
                    basicBiographics.gender,
                    basicBiographics.dateOfBirth,
                    citizenship,
                    disabilities,
                    address,
                    contacts)

        enum class Gender{

        }

        enum class EligibilityStatus{

        }

    open fun getBasicBiographics():IBiographics.IBasicBiographics
    {
        return BasicBiographics(identificationNumber, identificationType, externalCode,
            eligibilityStatus, firstName, middleName, lastName, lastName2, gender, dateOfBirth)
    }



    open class BasicBiographics (
        override val identificationNumber: String,
        override val identificationType: String,
        override val externalCode: String? = null,
        override val eligibilityStatus: EligibilityStatus,
        override val firstName: String,
        override val middleName: String? = null,
        override val lastName: String,
        override val lastName2: String? = null,
        override val gender: Gender,
        override val dateOfBirth: Date? = null):IBiographics.IBasicBiographics

}

