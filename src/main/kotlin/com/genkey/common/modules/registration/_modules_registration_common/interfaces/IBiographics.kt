package com.genkey.common.modules.registration._modules_registration_common.interfaces

import com.genkey.common.modules.registration._modules_registration_common.domain.Biographics
import com.genkey.common.modules.registration._modules_registration_common.domain.Biographics.EligibilityStatus
import com.genkey.common.modules.registration._modules_registration_common.domain.Biographics.Gender
import java.util.*

/**
 * It has the corresponding table in the dbase, but also this class aggregates other tables.
 */

interface IBiographics
{
    val identificationNumber: String
    val identificationType: String
    val externalCode: String?
    val eligibilityStatus: Biographics.EligibilityStatus
    val firstName: String
    val middleName: String?
    val lastName: String
    val lastName2: String?
    val gender: Biographics.Gender
    val dateOfBirth: Date?
    val citizenship: IIdCitizenship?
    val disabilities: List<IIdDisability>?
    val address: IIdAddress?
    val contacts: List<IIdContact>?

    interface IBasicBiographics
    {
        val identificationNumber: String
        val identificationType: String
        val externalCode: String?
        val eligibilityStatus: EligibilityStatus
        val firstName: String
        val middleName: String?
        val lastName: String
        val lastName2: String?
        val gender: Gender
        val dateOfBirth: Date?
    }
}