package com.genkey.common.modules.settings.module_settings_impl.repo.dbase

import com.genkey.common.modules.basic.RepoResultState
import com.genkey.common.modules.settings.module_settings_api.SettingsAPI
import com.genkey.common.modules.settings.module_settings_impl.repo.SettingsRepository

class SettingsRepositoryImpl: SettingsRepository
{
    override fun readSettings(): RepoResultState<SettingsAPI.Settings>
    {
        TODO("Not yet implemented")
    }

    override fun saveSettings(settings: SettingsAPI.Settings): RepoResultState<Unit>
    {
        TODO("Not yet implemented")
    }
}