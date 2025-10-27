package com.genkey.common.modules.settings.module_settings_impl

import com.genkey.common.modules.basic.AbstractModuleComp
import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.basic.RepoResultState
import com.genkey.common.modules.settings.module_settings_api.SettingsAPI
import com.genkey.common.modules.settings.module_settings_api.SettingsAPI.Settings
import com.genkey.common.modules.settings.module_settings_impl.repo.SettingsRepository
import com.genkey.common.modules.settings.module_settings_impl.repo.dbase.SettingsRepositoryImpl
import com.genkey.common.modules.settings.module_settings_impl.usecases.EditSettings_usecase

open class SettingsAPI_Impl: AbstractModuleComp(), SettingsAPI
{
    protected open val settingsRepository: SettingsRepository  = SettingsRepositoryImpl() //DI injected, singleton

    @Composable
    override suspend fun doSettingsManagement(): Settings
    {
        val editedSettings  = EditSettings_usecase(settingsRepository).showSettingsAndReturnEdited()
        return editedSettings
    }

    override fun getCurrentSettings(): Settings
    {
        val result = settingsRepository.readSettings() as RepoResultState.Success
        return result.value
    }
}