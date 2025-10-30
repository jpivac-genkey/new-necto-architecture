package com.genkey.common.modules.fingerprints.module_fingerprints_verify_api

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.fingerprints._module_fingerprints_common.FingerPrintsCommonAPI
import com.genkey.common.modules.fingerprints._module_fingerprints_common.FingerPrintsCommonAPI.IFingerPrints

interface  FPVerificationAPI: FingerPrintsCommonAPI
{
    @Composable
    suspend fun verifyFP(bioHash:ByteArray): Boolean

    @Composable
    suspend fun verifyFP(fingerPrintsToVerifyAgainst: IFingerPrints): Boolean
}