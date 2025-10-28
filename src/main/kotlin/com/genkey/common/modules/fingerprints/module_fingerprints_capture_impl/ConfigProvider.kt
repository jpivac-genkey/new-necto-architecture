package com.genkey.common.modules.fingerprints.module_fingerprints_capture_impl

import com.genkey.common.modules.basic.ConfigManager
import com.genkey.common.modules._main.ConfigManager_Impl

class ConfigProvider
{
    val configManager:ConfigManager = ConfigManager_Impl() //inserted by DI, singleton

    fun getConfiguration(): Configuration
    {
        return Configuration (
            fingerCaptureMaximumCaptureRetry= configManager.getInt("fingerCaptureMaximumCaptureRetry" , 3),
            fingerCaptureMaximumQualityRetry= configManager.getInt("fingerCaptureMaximumQualityRetry" , 3),
            remainingFingerMissingVisibility = configManager.getBoolean("remainingFingerMissingVisibility", false)
        )
    }

    data class Configuration(
        //these are just examples taken from the NectoProperties on Android
        val fingerCaptureMaximumCaptureRetry:Int,
        val fingerCaptureMaximumQualityRetry:Int,
        val remainingFingerMissingVisibility:Boolean

        //whatever more ...
    )
}