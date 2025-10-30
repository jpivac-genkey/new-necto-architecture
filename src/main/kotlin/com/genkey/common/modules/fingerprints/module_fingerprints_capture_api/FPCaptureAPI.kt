package com.genkey.common.modules.fingerprints.module_fingerprints_capture_api

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.fingerprints._module_fingerprints_common.FingerPrintsCommonAPI
import com.genkey.common.modules.fingerprints._module_fingerprints_common.FingerPrintsCommonAPI.IFingerPrints

interface  FPCaptureAPI: FingerPrintsCommonAPI
{
    @Composable
    suspend fun captureNewFingerPrints(): IFingerPrints

    suspend fun updateFingerPrints(existing: IFingerPrints): IFingerPrints
}