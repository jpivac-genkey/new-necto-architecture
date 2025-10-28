package com.genkey.zec.modules.d_signature.module_signature_api

import com.genkey.common.modules.d_signature.module_signature_api.SignatureAPI
import com.genkey.common.modules.d_signature.module_signature_api.SignatureAPI.Signature

interface ZEC_SignatureAPI : SignatureAPI
{
    //some other type of signature
    sealed class ZEC_Signature: Signature()
    {
        data class GoodSignatureCopiedFromSource(val image: ByteArray): Signature()
    }
}