package com.genkey.common.modules.registration._modules_registration_common.interfaces

import com.genkey.common.modules.registration._modules_registration_common.domain.Face
import com.genkey.common.modules.registration._modules_registration_common.domain.FingerPrints

/**
 * No corresponding table in the dbase. This class is kind of aggregator of other tables.
 */


interface IBiometrics
{
    val face: IIdFace?
    val fingerPrints: FingerPrints?
}