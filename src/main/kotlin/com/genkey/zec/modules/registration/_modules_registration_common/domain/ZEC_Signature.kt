package com.genkey.zec.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.d_signature.module_signature_api.SignatureAPI
import com.genkey.common.modules.registration._modules_registration_common.domain.Signature
import com.genkey.zec.modules.d_signature.module_signature_api.ZEC_SignatureAPI


abstract class ZEC_Signature: Signature()
{
    data class GoodSignatureCopiedFromSource( override val id: UUID,  override val sourceImage: ByteArray, override val image: ByteArray):
        ZEC_Signature(), ZEC_SignatureAPI.IZEC_Signature.IGoodSignatureCopiedFromSource
    {
        //used for receiving the output from Signature module
        constructor(goodSignature: ZEC_SignatureAPI.IZEC_Signature.IGoodSignatureCopiedFromSource):
                this(UUID.UNASSIGNED, goodSignature.sourceImage, goodSignature.image)
    }

    companion object:SignatureCreator
    {
        override operator fun invoke(signature: SignatureAPI.ISignature): Signature
        {
            return when(signature)
            {
                is ZEC_SignatureAPI.IZEC_Signature.IGoodSignatureCopiedFromSource -> GoodSignatureCopiedFromSource(signature)
                else -> Signature(signature)
            }
        }
    }

}