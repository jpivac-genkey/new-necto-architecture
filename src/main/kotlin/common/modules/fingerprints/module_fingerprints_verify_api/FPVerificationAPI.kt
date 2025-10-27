package com.genkey.common.modules.fingerprints.module_fingerprints_verify_api

import com.genkey.common.modules.basic.Composable

interface  FPVerificationAPI
{
    @Composable
    suspend fun verifyFP(bioHash:ByteArray): Boolean
}