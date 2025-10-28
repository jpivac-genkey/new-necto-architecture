package com.genkey.common.modules.d_signature.module_signature_impl

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.d_signature.module_signature_api.SignatureAPI
import com.genkey.common.modules.d_signature.module_signature_api.SignatureAPI.Signature

class  SignatureAPI_Impl: SignatureAPI
{
    @Composable
    override suspend fun captureSignature(): Signature
    {
        return Signature.ImpossibleToSign("")
    }

    override suspend fun updateSignature(existing:Signature): Signature
    {
        return Signature.ImpossibleToSign("")
    }
}



