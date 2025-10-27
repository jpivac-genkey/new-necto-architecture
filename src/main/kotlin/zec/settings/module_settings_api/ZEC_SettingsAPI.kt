package com.genkey.zec.settings.module_settings_api

import com.genkey.common.modules.settings.module_settings_api.SettingsAPI
import java.util.*

interface ZEC_SettingsAPI: SettingsAPI
{
     class ZEC_Settings(
        defaultLanguage:String,
        lockScreenTimeOutSec:Int,
        backupRestServer:String,
        backupFrequency:Int,
        resultsRestServer:String,
        resultsUploadFrequency:Int,
        updateRestServer:String,
        connectionTimeout:Int,
        val zecField1:Date,  // <----------------- new field !!!!!
        val zecField2:String,  // <----------------- new field !!!!!
        ): SettingsAPI.Settings(defaultLanguage, lockScreenTimeOutSec, backupRestServer,
                                backupFrequency, resultsRestServer, resultsUploadFrequency,
                                updateRestServer, connectionTimeout)
     {
         constructor(settings: SettingsAPI.Settings,
                     zecField1:Date,
                     zecField2:String):
                 this(
                      settings.defaultLanguage,
                      settings.lockScreenTimeOutSec,
                      settings.backupRestServer,
                      settings.backupFrequency,
                      settings.resultsRestServer,
                      settings.resultsUploadFrequency,
                      settings.updateRestServer,
                      settings.connectionTimeout,
                      zecField1,
                      zecField2)

     }



}