package com.genkey.zec.modules.d_signature.module_signature_impl.usecases

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.d_signature.module_signature_api.SignatureAPI
import com.genkey.common.modules.d_signature.module_signature_api.SignatureAPI.Signature
import com.genkey.zec.modules.d_signature.module_signature_api.ZEC_SignatureAPI

class  ZEC_SignatureAPI_Impl: SignatureAPI
{
    @Composable
    override suspend fun captureSignature(): Signature
    {
        return Signature.ImpossibleToSign("")
    }

    override suspend fun updateSignature(existing:Signature): Signature
    {
        return ZEC_SignatureAPI.ZEC_Signature.GoodSignatureCopiedFromSource(ByteArray(0))
    }
}



