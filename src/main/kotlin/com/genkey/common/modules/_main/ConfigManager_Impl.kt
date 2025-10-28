package com.genkey.common.modules._main

import com.genkey.common.modules.basic.ConfigManager
import java.util.*

class ConfigManager_Impl: ConfigManager
{
    private lateinit var  properties: Properties

    fun init()
    {
        //read properties from a file
    }

    override fun getInt(key: String, default: Int): Int =
        properties.getProperty(key)?.toIntOrNull() ?: default

    override fun getFloat(key: String, default: Float ): Float =
        properties.getProperty(key)?.toFloatOrNull() ?: default

    override fun getBoolean(key: String, default: Boolean ): Boolean =
        properties.getProperty(key)?.lowercase()?.let {
            it == "true" || it == "1" || it == "yes" || it == "y" || it == "on"
        } ?: default

    override fun getString(key: String, default: String): String =
        properties.getProperty(key)?: default
}