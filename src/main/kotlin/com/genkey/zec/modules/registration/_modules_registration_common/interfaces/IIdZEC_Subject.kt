package com.genkey.zec.modules.registration._modules_registration_common.interfaces

import com.genkey.common.modules.registration._modules_registration_common.interfaces.IIdSubject


interface IIdZEC_Subject: IIdSubject
{
    override val biographics: IZEC_Biographics
    override val signature: IIdZEC_Signature?
    override val documents: List<IIdZEC_Document>?
}