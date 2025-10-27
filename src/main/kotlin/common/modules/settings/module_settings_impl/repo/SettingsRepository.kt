package com.genkey.common.modules.settings.module_settings_impl.repo

import com.genkey.common.modules.basic.RepoResultState
import com.genkey.common.modules.settings.module_settings_api.SettingsAPI

interface SettingsRepository
{
    fun readSettings(): RepoResultState<SettingsAPI.Settings>
    fun saveSettings(settings: SettingsAPI.Settings): RepoResultState<Unit>
}