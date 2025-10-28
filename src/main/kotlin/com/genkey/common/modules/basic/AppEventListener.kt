package com.genkey.common.modules.basic

import com.genkey.common.modules.settings.module_settings_api.SettingsAPI
import com.genkey.common.modules.users.module_users_api.UsersAPI

//just do nothing
open class DefaultAppEventListenerImpl : AppEventListener
{
    override fun onCurrentUserChanged(user: UsersAPI.UserRoles) {}
    override fun onSettingsChanged(settings: SettingsAPI.Settings) {}
    override fun onLowBattery() {}
    override fun onCriticalError() {}
    override fun onExit() {}
}

interface AppEventListener
{
    fun onCurrentUserChanged(user: UsersAPI.UserRoles)
    fun onSettingsChanged(settings: SettingsAPI.Settings)
    fun onLowBattery()
    fun onCriticalError()
    fun onExit()
}