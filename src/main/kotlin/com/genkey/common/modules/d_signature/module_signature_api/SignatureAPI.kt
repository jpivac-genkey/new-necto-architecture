package com.genkey.common.modules.d_signature.module_signature_api

import com.genkey.common.modules.basic.Composable


interface SignatureAPI
{
    @Composable
    suspend fun captureSignature(): ISignature

    @Composable
    suspend fun updateSignature(existing:ISignature): ISignature

    //it must be open (not sealed) if we want to derive from it
    interface ISignature
    {
        interface IGoodSignature:ISignature
        {
            val image: ByteArray
        }
        interface IImpossibleToSign:ISignature
        {
            val reason: String
        }
    }
}




