package com.genkey.common.modules.d_signature.module_signature_api

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.registration._modules_registration_domain.Signature


interface SignatureAPI
{
    @Composable
    suspend fun captureSignature(): Signature

    @Composable
    suspend fun updateSignature(existing:Signature): Signature

}




