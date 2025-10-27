package com.genkey.common.modules._main

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.registration._modules_registration_main_api.RegistrationAPI
import com.genkey.common.modules.registration._modules_registration_main_impl.RegistrationAPI_Impl
import com.genkey.common.modules.settings.module_settings_api.SettingsAPI
import com.genkey.common.modules.settings.module_settings_impl.SettingsAPI_Impl
import com.genkey.common.modules.users.module_users_api.UsersAPI
import com.genkey.common.modules.users.module_users_impl.UsersAPI_Impl

class LoginOutManager : UsersAPI.TimeoutManager.TimeoutExpiredListener
{
    val usersAPI : UsersAPI = UsersAPI_Impl() //DI injected, singleton
    val settingsApi: SettingsAPI = SettingsAPI_Impl() //DI injected, singleton
    val registrationAPI: RegistrationAPI = RegistrationAPI_Impl() //DI injected, singleton

    lateinit var timeoutManager: UsersAPI.TimeoutManager

    fun init()
    {
        timeoutManager = usersAPI.getTimeoutManager()
        timeoutManager.registerListener(this)
    }

    @Composable
    suspend fun startLogin()
    {
        val user = usersAPI.handleLogin()

        settingsApi.onCurrentUserChanged(user)
        registrationAPI.onCurrentUserChanged(user)
    }

    override fun onTimeoutExpired()
    {
        val isUserStaysLoggedIn = timeoutManager.showTimeoutDialog()
        if(!isUserStaysLoggedIn)
        {
            settingsApi.onExit()
            registrationAPI.onExit()

            //--> exit the whole app
        }
    }
}