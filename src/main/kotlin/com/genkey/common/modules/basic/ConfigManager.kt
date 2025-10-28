package com.genkey.common.modules.basic

interface ConfigManager
{
    fun getInt(key: String, default: Int = 0): Int
    fun getFloat(key: String, default: Float = 0f): Float
    fun getBoolean(key: String, default: Boolean = false): Boolean
    fun getString(key: String, default: String = ""): String
}