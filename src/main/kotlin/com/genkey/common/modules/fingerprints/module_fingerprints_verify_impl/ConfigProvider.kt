package com.genkey.common.modules.fingerprints.module_fingerprints_verify_impl

import com.genkey.common.modules._main.ConfigManager_Impl
import com.genkey.common.modules.basic.ConfigManager

class ConfigProvider
{
    val configManager:ConfigManager = ConfigManager_Impl() //inserted by DI, singleton

    fun getConfiguration(): Configuration
    {
        return Configuration (
            verifyMinimumFinger= configManager.getInt("verifyMinimumFinger" , 3),
            verifyPositionDependent = configManager.getBoolean("verifyPositionDependent", false),
        )
    }

    data class Configuration(
        //these are just examples taken from the NectoProperties on Android
        val verifyMinimumFinger:Int,
        val verifyPositionDependent:Boolean

        //whatever more ...
        )

}