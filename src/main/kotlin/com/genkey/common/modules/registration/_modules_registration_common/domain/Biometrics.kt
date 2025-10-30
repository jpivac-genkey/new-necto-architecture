package com.genkey.common.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.registration._modules_registration_common.interfaces.IBiometrics
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IFace
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IIdFace


open class Biometrics (
    override val face: IIdFace?,
    override val fingerPrints: FingerPrints?,
    ): IBiometrics

