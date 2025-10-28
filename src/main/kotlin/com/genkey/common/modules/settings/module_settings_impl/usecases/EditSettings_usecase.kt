package com.genkey.common.modules.settings.module_settings_impl.usecases

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.basic.RepoResultState
import com.genkey.common.modules.settings.module_settings_api.SettingsAPI
import com.genkey.common.modules.settings.module_settings_impl.repo.SettingsRepository

open class EditSettings_usecase(
    val settingsRepository: SettingsRepository
)
{
    @Composable
    suspend fun showSettingsAndReturnEdited():SettingsAPI.Settings
    {
        val result = settingsRepository.readSettings() as RepoResultState.Success //should be checked for error
        val settings =  result.value

        //... show values on the screen
        fillFieldsWithSettings(settings)

        //wait until the user has finished editing

        //return edited values
        val editedSettings = createSettingsFromFields()
        settingsRepository.saveSettings(editedSettings)
        return editedSettings
    }

    protected open fun fillFieldsWithSettings(settings:SettingsAPI.Settings)
    {
        val defaultLanguage = settings.defaultLanguage
        val backupFrequency = settings.backupFrequency
        val backupRestServer = settings.backupRestServer
        val updateRestServer= settings.updateRestServer
        val resultsRestServer= settings.resultsRestServer
        val connectionTimeout= settings.connectionTimeout
        val lockScreenTimeOutSec= settings.lockScreenTimeOutSec
        val resultsUploadFrequency= settings.resultsUploadFrequency
    }

    protected open fun createSettingsFromFields():SettingsAPI.Settings
    {
        //read the edited values on the screen
        val editedDefaultLanguage:String = ""
        val editedBackupFrequency:Int = 0
        val editedBackupRestServer = ""
        val editedUpdateRestServer= ""
        val editedResultsRestServer= ""
        val editedConnectionTimeout= 0
        val editedLockScreenTimeOutSec= 0
        val editedResultsUploadFrequency= 0

        return SettingsAPI.Settings(editedDefaultLanguage,
            editedLockScreenTimeOutSec, editedBackupRestServer, editedBackupFrequency,
            editedResultsRestServer, editedResultsUploadFrequency, editedUpdateRestServer, editedConnectionTimeout)
    }

}