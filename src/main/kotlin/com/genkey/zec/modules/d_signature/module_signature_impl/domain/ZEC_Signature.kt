package com.genkey.zec.modules.d_signature.module_signature_impl.domain

import com.genkey.common.modules.basic.ImageBytesHolder
import com.genkey.zec.modules.d_signature.module_signature_api.ZEC_SignatureAPI.IZEC_Signature

class ZEC_Signature:IZEC_Signature
{
    data class GoodSignatureCopiedFromSource(
        override val sourceImage: ImageBytesHolder,
        override val image: ImageBytesHolder)
        :IZEC_Signature.IGoodSignatureCopiedFromSource
}