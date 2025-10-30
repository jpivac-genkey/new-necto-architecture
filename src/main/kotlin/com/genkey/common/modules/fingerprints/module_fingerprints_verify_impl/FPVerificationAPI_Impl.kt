package com.genkey.common.modules.fingerprints.module_fingerprints_verify_impl

import com.genkey.common.modules.basic.AbstractModuleComp
import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.fingerprints._module_fingerprints_common.FingerPrintsCommonAPI.IFingerPrints
import com.genkey.common.modules.fingerprints.module_fingerprints_verify_api.FPVerificationAPI

class FPVerificationAPI_Impl : AbstractModuleComp(), FPVerificationAPI
{
    private val configProvider = ConfigProvider()

    @Composable
    override suspend fun verifyFP(imageToVerifyAgainst: ByteArray): Boolean
    {
        val configuration = configProvider.getConfiguration()
        return true
    }

    @Composable
    override suspend fun verifyFP(fingerPrintsToVerifyAgainst: IFingerPrints): Boolean
    {
        val configuration = configProvider.getConfiguration()
        return true
    }
}