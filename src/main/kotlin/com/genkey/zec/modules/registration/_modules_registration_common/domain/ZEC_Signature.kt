package com.genkey.zec.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_common.domain.IIdSignature
import com.genkey.common.modules.registration._modules_registration_common.domain.Signature
import com.genkey.zec.modules.d_signature.module_signature_api.ZEC_SignatureAPI
import com.genkey.zec.modules.registration._modules_registration_common.interfaces.IIdZEC_Signature


open class ZEC_Signature(override val id: UUID): IIdSignature
{
    data class GoodSignatureCopiedFromSource(private val signature: IIdSignature, override val sourceImage: ByteArray, override val image: ByteArray):
        IIdSignature by signature, IIdZEC_Signature.IId_IGoodSignatureCopiedFromSource
    {
        //used for receiving the data from Repository
        constructor(id: UUID, sourceImage: ByteArray, image: ByteArray): this(Signature(id), sourceImage, image)

        //used for receiving the output from Signature module
        constructor(goodSignature: ZEC_SignatureAPI.IZEC_Signature.IGoodSignatureCopiedFromSource): this(UUID.UNASSIGNED, goodSignature.sourceImage, goodSignature.image)
    }

}