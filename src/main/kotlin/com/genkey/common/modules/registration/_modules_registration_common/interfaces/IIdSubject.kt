package com.genkey.common.modules.registration._modules_registration_common.interfaces

import com.genkey.common.modules.registration._modules_registration_common.domain.IIdDocument
import com.genkey.common.modules.registration._modules_registration_common.domain.IIdSignature
import java.util.*

interface IIdSubject: ISubject, IHavingID

interface ISubject
{
    val registrationDate: Date
    open val biographics: IBiographics
    open val biometrics: IBiometrics?
    open val signature: IIdSignature?
    open val documents: List<IIdDocument>?
}