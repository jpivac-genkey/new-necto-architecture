package com.genkey.common.modules.fingerprints.module_fingerprints_capture_impl

import com.genkey.common.modules.basic.AbstractModuleComp
import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.fingerprints.module_fingerprints_capture_api.FPCaptureAPI
import com.genkey.common.modules.fingerprints.module_fingerprints_capture_api.FPCaptureAPI.FingerPrint

class FPCaptureAPI_Impl : AbstractModuleComp(), FPCaptureAPI
{
    private val configProvider = ConfigProvider()

    @Composable
    override suspend fun captureNewFingerPrints(): List<FingerPrint>
    {
        val configuration = configProvider.getConfiguration()
        TODO()
    }

    @Composable
    override suspend fun updateFingerPrints(existing: List<FingerPrint>): List<FingerPrint>
    {
        val configuration = configProvider.getConfiguration()
        TODO()
    }

}