package com.genkey.common.modules.d_signature.module_signature_impl

import com.genkey.common.modules.d_signature.module_signature_api.SignatureAPI
import com.genkey.common.modules.d_signature.module_signature_api.SignatureAPI.ISignature

sealed class Signature:SignatureAPI.ISignature
{
    data class GoodSignature(override val image: ByteArray): ISignature.IGoodSignature
    data class ImpossibleToSign(override val  reason: String): ISignature.IImpossibleToSign
}