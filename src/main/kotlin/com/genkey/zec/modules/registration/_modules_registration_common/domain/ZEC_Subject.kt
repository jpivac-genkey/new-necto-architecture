package com.genkey.zec.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_common.domain.Biometrics
import com.genkey.common.modules.registration._modules_registration_common.domain.Signature
import com.genkey.common.modules.registration._modules_registration_common.domain.Subject
import java.util.*


open class ZEC_Subject(
    id: UUID? = null,
    registrationDate: Date,
    override val biographics: ZEC_Biographics,
    biometrics: Biometrics? = null,
    override val signature: Signature? = null, //can not use ZEC_Signature here
    override val documents: List<ZEC_Document>? = null
):Subject(id, registrationDate, biographics, biometrics, signature)



