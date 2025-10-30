package com.genkey.zec.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.registration._modules_registration_common.domain.Biographics
import com.genkey.common.modules.registration._modules_registration_common.domain.IIdDocumentPage
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IBiographics
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IIdAddress
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IIdCitizenship
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IIdDisability
import com.genkey.zec.modules.registration._modules_registration_common.interfaces.IZEC_Biographics
import java.util.*

interface IIdZEC_Biographics: IZEC_Biographics, IIdDocumentPage

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
    override val zecField1: Date, // <----------------- new field !!!!!
    citizenship: IIdCitizenship? = null,
    disabilities: List<IIdDisability>? = null,
    address: IIdAddress? = null,
    override val contacts: List<ZEC_Contact>? = null
    ): Biographics(
                    identificationNumber, identificationType, externalCode,
                    eligibilityStatus, firstName, middleName, lastName, lastName2,
                    gender, dateOfBirth, citizenship, disabilities, address, contacts
    ), IZEC_Biographics
{
        constructor(basicBiographics: IZEC_BasicBiographics,
                    citizenship: IIdCitizenship? = null,
                    disabilities: List<IIdDisability>? = null,
                    address: IIdAddress? = null,
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

    override fun getBasicBiographics():IZEC_BasicBiographics
    {
        return ZEC_BasicBiographics(identificationNumber, identificationType, externalCode,
            eligibilityStatus, firstName, middleName, lastName, lastName2, gender, dateOfBirth, zecField1)
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
        override val zecField1: Date)
        : Biographics.BasicBiographics(identificationNumber,
        identificationType,
        externalCode,
        eligibilityStatus,
        firstName,
        middleName,
        lastName,
        lastName2,
        gender,
        dateOfBirth),IZEC_BasicBiographics

    interface IZEC_BasicBiographics : IBiographics.IBasicBiographics
    {
        val zecField1: Date
    }
}

