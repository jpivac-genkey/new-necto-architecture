package com.genkey.common.modules.d_signature.module_signature_impl

import com.genkey.common.modules.basic.ImageBytesHolder
import com.genkey.common.modules.d_signature.module_signature_api.SignatureAPI
import com.genkey.common.modules.d_signature.module_signature_api.SignatureAPI.ISignature

open class Signature:SignatureAPI.ISignature
{
    data class GoodSignature(override val image: ImageBytesHolder): ISignature.IGoodSignature
    data class ImpossibleToSign(override val  reason: String): ISignature.IImpossibleToSign
}