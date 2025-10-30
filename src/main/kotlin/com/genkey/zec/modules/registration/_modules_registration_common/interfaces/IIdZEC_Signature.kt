package com.genkey.zec.modules.registration._modules_registration_common.interfaces

import com.genkey.common.modules.registration._modules_registration_common.domain.IIdSignature
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IHavingID
import com.genkey.zec.modules.d_signature.module_signature_api.ZEC_SignatureAPI

interface IIdZEC_Signature: IIdSignature, IHavingID
{
    interface IId_IGoodSignatureCopiedFromSource:ZEC_SignatureAPI.IZEC_Signature.IGoodSignatureCopiedFromSource, IIdZEC_Signature
}