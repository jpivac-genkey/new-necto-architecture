package com.genkey.zec.modules.d_signature.module_signature_api

import com.genkey.common.modules.basic.ImageBytesHolder
import com.genkey.common.modules.d_signature.module_signature_api.SignatureAPI


interface ZEC_SignatureAPI : SignatureAPI
{
    //some other type of signature
    interface IZEC_Signature: SignatureAPI.ISignature
    {
        interface IGoodSignatureCopiedFromSource: IZEC_Signature
        {
            val image: ImageBytesHolder
            val sourceImage: ImageBytesHolder
        }
    }
}