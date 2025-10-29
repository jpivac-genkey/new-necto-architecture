package com.genkey.common.modules.fingerprints.module_fingerprints_capture_api

import com.genkey.common.modules.basic.Composable

interface  FPCaptureAPI
{
    @Composable
    suspend fun captureNewFingerPrints(): List<FingerPrint>

    suspend fun updateFingerPrints(existing: List<FingerPrint>): List<FingerPrint>

    open class FingerPrint(val idc: Int)
    {
        open class GoodFingerPrint(idc:Int, val image: ByteArray) : FingerPrint(idc)

        open class ImpossibleToCapture(idc:Int, val reason: String) : FingerPrint(idc)

        open class TraumaFingerPrint(idc:Int, val traumaType: TraumaType,
                                val traumaDetails: String,
                                val isTraumaPermanent: Boolean) : FingerPrint(idc)
        {
            enum class TraumaType
            {
                //
            }
        }
    }
}