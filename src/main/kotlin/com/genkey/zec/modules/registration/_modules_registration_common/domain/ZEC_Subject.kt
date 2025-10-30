package com.genkey.zec.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_common.domain.Subject
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IBiometrics
import com.genkey.zec.modules.registration._modules_registration_common.interfaces.IIdZEC_Document
import com.genkey.zec.modules.registration._modules_registration_common.interfaces.IIdZEC_Signature
import com.genkey.zec.modules.registration._modules_registration_common.interfaces.IIdZEC_Subject
import com.genkey.zec.modules.registration._modules_registration_common.interfaces.IZEC_Biographics
import java.util.*


open class ZEC_Subject(
    id: UUID,
    registrationDate: Date,
    override val biographics: IZEC_Biographics,
    biometrics: IBiometrics? = null,
    override val signature: IIdZEC_Signature? = null,
    override val documents: List<IIdZEC_Document>? = null
):Subject(id, registrationDate, biographics, biometrics, signature),IIdZEC_Subject



