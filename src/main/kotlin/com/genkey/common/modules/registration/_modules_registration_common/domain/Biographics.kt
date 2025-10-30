package com.genkey.common.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.ValInterface
import com.genkey.common.modules.registration._modules_registration_common.domain.Biographics.EligibilityStatus
import com.genkey.common.modules.registration._modules_registration_common.domain.Biographics.Gender
import com.genkey.common.modules.registration._modules_registration_common.domain.Citizenship.DocumentType
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
/**
 * It has the corresponding table in the dbase, but also this class aggregates other tables.
 */
open class Biographics(
    val identificationNumber: String,
    val identificationType: String,
    val externalCode: String? = null,
    val eligibilityStatus: EligibilityStatus,
    val firstName: String,
    val middleName: String? = null,
    val lastName: String,
    val lastName2: String? = null,
    val gender: Gender,
    val dateOfBirth: Date? = null,
    open val citizenship: Citizenship? = null,
    open val disabilities: List<Disability>? = null,
    open val address: Address? = null,
    open val contacts: List<Contact>? = null
    )
{
        constructor(basicBiographics: BasicBiographics,
                    citizenship: Citizenship? = null,
                    disabilities: List<Disability>? = null,
                    address: Address? = null,
                    contacts: List<Contact>? = null
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

    interface Gender: ValInterface
    interface EligibilityStatus: ValInterface


    enum class GenderEnum(override val value: Int): Gender
    {

    }

    enum class EligibilityStatusEnum(override val value: Int): EligibilityStatus
    {

    }

    open fun getBasicBiographics():BasicBiographics
    {
        return BasicBiographics(identificationNumber, identificationType, externalCode,
            eligibilityStatus, firstName, middleName, lastName, lastName2, gender, dateOfBirth)
    }

    open class BasicBiographics (
        val identificationNumber: String,
        val identificationType: String,
        val externalCode: String? = null,
        val eligibilityStatus: EligibilityStatus,
        val firstName: String,
        val middleName: String? = null,
        val lastName: String,
        val lastName2: String? = null,
        val gender: Gender,
        val dateOfBirth: Date? = null)

}

