package com.genkey.zec.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.registration._modules_registration_common.domain.*
import com.genkey.common.modules.registration._modules_registration_domain.Biographics.EligibilityStatus
import com.genkey.common.modules.registration._modules_registration_domain.Biographics.Gender
import com.genkey.common.modules.registration._modules_registration_domain.Address
import com.genkey.common.modules.registration._modules_registration_domain.Biographics
import com.genkey.common.modules.registration._modules_registration_domain.Citizenship
import com.genkey.common.modules.registration._modules_registration_domain.Disability
import java.util.*


class ZEC_Biographics(
    identificationNumber: String,
    identificationType: String,
    externalCode: String? = null,
    eligibilityStatus: EligibilityStatus,
    firstName: String,
    middleName: String? = null,
    lastName: String,
    lastName2: String? = null,
    gender: Gender,
    dateOfBirth: Date? = null,
    val zecField1: Date, // <----------------- new field !!!!!
    citizenship: Citizenship? = null,
    disabilities: List<Disability>? = null,
    address: Address? = null,
    contacts: List<ZEC_Contact>? = null
    ): Biographics(
                    identificationNumber, identificationType, externalCode,
                    eligibilityStatus, firstName, middleName, lastName, lastName2,
                    gender, dateOfBirth, citizenship, disabilities, address, contacts
    )
{
        constructor(basicBiographics: ZEC_BasicBiographics,
                    citizenship: Citizenship? = null,
                    disabilities: List<Disability>? = null,
                    address: Address? = null,
                    contacts: List<ZEC_Contact>? = null
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
                    basicBiographics.zecField1,
                    citizenship,
                    disabilities,
                    address,
                    contacts)

    override fun getBasicBiographics():BasicBiographics
    {
        return ZEC_BasicBiographics(identificationNumber, identificationType, externalCode,
            eligibilityStatus, firstName, middleName, lastName, lastName2, gender, dateOfBirth, zecField1)
    }

}

open class ZEC_BasicBiographics (
    identificationNumber: String,
    identificationType: String,
    externalCode: String? = null,
    eligibilityStatus: EligibilityStatus,
    firstName: String,
    middleName: String? = null,
    lastName: String,
    lastName2: String? = null,
    gender: Gender,
    dateOfBirth: Date? = null,
    val zecField1: Date)
    : Biographics.BasicBiographics(identificationNumber,
                       identificationType,
                       externalCode,
                       eligibilityStatus,
                       firstName,
                       middleName,
                       lastName,
                       lastName2,
                       gender,
                       dateOfBirth)