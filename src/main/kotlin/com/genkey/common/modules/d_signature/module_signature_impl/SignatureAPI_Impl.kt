package com.genkey.common.modules.d_signature.module_signature_impl

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.d_signature.module_signature_api.SignatureAPI
import com.genkey.common.modules.d_signature.module_signature_api.SignatureAPI.ISignature

open class  SignatureAPI_Impl: SignatureAPI
{
    @Composable
    override suspend fun captureSignature(): ISignature
    {
        return ISignature.IImpossibleToSign("")
    }

    override suspend fun updateSignature(existing:ISignature): ISignature
    {
        return ISignature.IImpossibleToSign("")
    }
}



