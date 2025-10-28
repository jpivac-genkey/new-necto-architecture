package com.genkey.common.modules.settings.module_settings_api

import com.genkey.common.modules.basic.AppEventListener
import com.genkey.common.modules.basic.Composable

interface SettingsAPI: AppEventListener
{
    fun getCurrentSettings(): Settings

    @Composable
    suspend fun doSettingsManagement():Settings

    open class Settings(
        //these are just examples taken from the Necto Android
        val defaultLanguage:String,
        val lockScreenTimeOutSec:Int,
        val backupRestServer:String,
        val backupFrequency:Int,
        val resultsRestServer:String,
        val resultsUploadFrequency:Int,
        val updateRestServer:String,
        val connectionTimeout:Int)
}