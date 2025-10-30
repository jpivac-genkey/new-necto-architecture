package com.genkey.common.modules.registration._modules_registration_common.interfaces

import com.genkey.common.modules.registration._modules_registration_common.domain.Disability


interface IIdDisability: IDisability, IHavingID

interface IDisability
{
    val disabilityType: TraumaType
    val disabilityDetails: TraumaDetail?
    val isPermanent: Boolean?

    enum class TraumaType
    {
        OTHER, FACIAL, BLIND, MISSING_LIMB, ILLITERATE, UNABLE_TO_SIGN, DEAF, BAD_QUALITY, DUMB, DEAF_AND_DUMB, INCOMPETENT
    }

    enum class TraumaDetail
    {
        TRAUMA_BOTH, TRAUMA_FINGER, TRAUMA_LEFT, TRAUMA_OTHER, TRAUMA_RIGHT,
        TRAUMA_LEFT_HAND, TRAUMA_RIGHT_HAND, TRAUMA_ALL
    }
}