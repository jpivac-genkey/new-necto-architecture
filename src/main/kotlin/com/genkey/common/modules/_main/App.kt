package com.genkey.common.modules._main

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.registration._modules_registration_main_api.RegistrationAPI
import com.genkey.common.modules.registration._modules_registration_main_impl.RegistrationAPI_Impl
import com.genkey.common.modules.settings.module_settings_api.SettingsAPI
import com.genkey.common.modules.users.module_users_api.UsersAPI
import com.genkey.common.modules.users.module_users_impl.UsersAPI_Impl
import com.genkey.zec.modules.settings.module_settings_impl.ZEC_SettingsAPI_Impl
import java.awt.Button

open class App
{
    protected open val usersAPI : UsersAPI= UsersAPI_Impl() //DI injected, singleton
    protected open val settingsApi: SettingsAPI = ZEC_SettingsAPI_Impl() //DI injected, singleton
    protected open val registrationAPI: RegistrationAPI = RegistrationAPI_Impl() //DI injected, singleton

    protected open val appEventsNotifier = AppEventsNotifier()
    protected open val loginOutManager = LoginOutManager()

    @Composable
    suspend fun onStart()
    {
        appEventsNotifier.init()
        loginOutManager.init()

        loginOutManager.startLogin()
        notifyAnybodyInterestedInSettings()
        showMainMenu()
    }


    @Composable
    protected open suspend fun showMainMenu()
    {

    }

    @Composable
    protected open suspend fun onClick()
    {
        val button_clicked: Button = "" as Button
        when(button_clicked.label)
        {
            "NEW SUBJECT" -> registrationAPI.addNewSubject()
            "UPDATE SUBJECT" -> registrationAPI.updateSubject()
            "EDIT USERS" -> usersAPI.doUsersManagement()
            "EDIT SETTINGS" -> handleEditSettings()
            "COMING HOME" -> registrationAPI.doComingHome()
        }
    }

    @Composable
    private suspend fun handleEditSettings()
    {
        val existingSettings = settingsApi.getCurrentSettings()
        val updatedSettings = settingsApi.doSettingsManagement()
        if(existingSettings != updatedSettings)
        {
            notifyAnybodyInterestedInSettings()
        }
    }

    private suspend fun notifyAnybodyInterestedInSettings()
    {
        val currentSettings = settingsApi.getCurrentSettings()
        usersAPI.onSettingsChanged(currentSettings)
        registrationAPI.onSettingsChanged(currentSettings)
    }
}