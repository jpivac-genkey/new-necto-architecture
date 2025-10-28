package com.genkey.common.modules.d_signature.module_signature_impl

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.d_signature.module_signature_api.SignatureAPI
import com.genkey.common.modules.registration._modules_registration_domain.Signature

class  SignatureAPI_Impl: SignatureAPI
{
    @Composable
    override suspend fun captureSignature(): Signature
    {
        TODO()
    }

    override suspend fun updateSignature(existing:Signature): Signature
    {
        TODO()
    }
}



