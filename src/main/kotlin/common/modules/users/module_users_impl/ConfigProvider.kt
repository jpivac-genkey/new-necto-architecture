package com.genkey.common.modules.users.module_users_impl

import com.genkey.common.modules.basic.ConfigManager
import com.genkey.common.modules._main.ConfigManager_Impl

class ConfigProvider
{
    val configManager: ConfigManager = ConfigManager_Impl() //inserted by DI injection

    fun getConfiguration():Configuration
    {
        return Configuration (
            maxOperatorsAllowed= configManager.getInt("maxOperatorsAllowed" , 50),
            userFacialCaptureRequired = configManager.getBoolean("userFacialCaptureRequired", false),
            isUsersUploaded = configManager.getBoolean("isUsersUploaded", false),
        )
    }

    data class Configuration(
        //these are just examples taken from the NectoProperties on Android
        val maxOperatorsAllowed:Int,
        val userFacialCaptureRequired:Boolean,
        val isUsersUploaded:Boolean,

        //and whatever else ...
    )

}