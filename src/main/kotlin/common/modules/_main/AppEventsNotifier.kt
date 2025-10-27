package com.genkey.common.modules._main

import com.genkey.common.modules.registration._modules_registration_main_api.RegistrationAPI
import com.genkey.common.modules.registration._modules_registration_main_impl.RegistrationAPI_Impl
import com.genkey.common.modules.settings.module_settings_api.SettingsAPI
import com.genkey.common.modules.settings.module_settings_impl.SettingsAPI_Impl
import com.genkey.common.modules.users.module_users_api.UsersAPI
import com.genkey.common.modules.users.module_users_impl.UsersAPI_Impl

class AppEventsNotifier
{
    val usersAPI : UsersAPI = UsersAPI_Impl() //DI injected, singleton
    val settingsApi: SettingsAPI = SettingsAPI_Impl() //DI injected, singleton
    val registrationAPI: RegistrationAPI = RegistrationAPI_Impl() //DI injected, singleton

    fun init()
    {
        listenToLowBatteryAndNotify()
        listenToCriticalErrorAndNotify()
    }

    private fun listenToLowBatteryAndNotify()
    {
        //logic for checking the battery level
        val isLowBattery = true
        if(isLowBattery) {
            usersAPI.onLowBattery()
            settingsApi.onLowBattery()
            registrationAPI.onLowBattery()
        }
    }

    private fun listenToCriticalErrorAndNotify()
    {
        //logic for checking on a critical error
        val isCriticalError = true
        if(isCriticalError) {
            usersAPI.onCriticalError()
            settingsApi.onCriticalError()
            registrationAPI.onCriticalError()
        }
    }

}