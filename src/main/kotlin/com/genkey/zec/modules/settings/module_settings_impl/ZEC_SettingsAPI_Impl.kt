package com.genkey.zec.modules.settings.module_settings_impl

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.settings.module_settings_api.SettingsAPI
import com.genkey.common.modules.settings.module_settings_impl.SettingsAPI_Impl
import com.genkey.zec.modules.settings.module_settings_api.ZEC_SettingsAPI
import com.genkey.zec.modules.settings.module_settings_impl.repo.dbase.ZEC_SettingsRepositoryImpl
import com.genkey.zec.modules.settings.module_settings_impl.usecases.ZEC_EditSettings_usecase

class ZEC_SettingsAPI_Impl: SettingsAPI_Impl(), ZEC_SettingsAPI
{
    override val settingsRepository = ZEC_SettingsRepositoryImpl()

    @Composable
    override suspend fun doSettingsManagement(): SettingsAPI.Settings
    {
        val editedSettings = ZEC_EditSettings_usecase(settingsRepository).showSettingsAndReturnEdited()
        return editedSettings
    }
}