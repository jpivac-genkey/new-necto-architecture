package com.genkey.common.modules.d_signature.module_signature_api

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.basic.UUID


interface SignatureAPI
{
    @Composable
    suspend fun captureSignature(): Signature

    @Composable
    suspend fun updateSignature(existing:Signature): Signature

    //it must be open (not sealed) if we want to derive from it
    open class Signature
    {
        data class GoodSignature(val image: ByteArray): Signature()
        data class ImpossibleToSign(val reason: String): Signature()
    }
}




