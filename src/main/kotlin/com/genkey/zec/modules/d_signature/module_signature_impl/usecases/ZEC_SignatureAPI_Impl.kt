package com.genkey.zec.modules.d_signature.module_signature_impl.usecases

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.d_signature.module_signature_api.SignatureAPI
import com.genkey.common.modules.d_signature.module_signature_impl.Signature
import com.genkey.common.modules.d_signature.module_signature_impl.SignatureAPI_Impl
import com.genkey.zec.modules.d_signature.module_signature_api.ZEC_SignatureAPI
import com.genkey.zec.modules.d_signature.module_signature_impl.domain.ZEC_Signature

class  ZEC_SignatureAPI_Impl: SignatureAPI_Impl(), ZEC_SignatureAPI
{
    @Composable
    override suspend fun captureSignature(): SignatureAPI.ISignature
    {
        return Signature.ImpossibleToSign("")
    }

    override suspend fun updateSignature(existing:SignatureAPI.ISignature): SignatureAPI.ISignature
    {
        return ZEC_Signature.GoodSignatureCopiedFromSource(ByteArray(0), ByteArray(0))
    }
}



