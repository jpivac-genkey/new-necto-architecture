package com.genkey.common.modules.document.module_document_impl

import com.genkey.common.modules.basic.ConfigManager
import com.genkey.common.modules._main.ConfigManager_Impl

open class ConfigProvider
{
    protected val configManager:ConfigManager = ConfigManager_Impl() //inserted by DI, singleton

    open fun getConfiguration(): Configuration
    {
        return Configuration (
            scanOnlyPDF = configManager.getBoolean("scanOnlyPDF", false),
            documentsRequired = configManager.getString("documentsRequired", "AFFIDAVIT,DRIVER_LICENSE"),
            atleastOneDocumentRequired = configManager.getString("atleastOneDocumentRequired", ""),
        )
    }

    open class Configuration(
        //these are just examples taken from the NectoProperties on Android
        val scanOnlyPDF:Boolean,
        val documentsRequired:String,
        val atleastOneDocumentRequired:String,

        //whatever more ...
        )

}