package com.genkey.zec

import com.genkey.common.modules._main.App
import com.genkey.zec.settings.module_settings_impl.ZEC_SettingsAPI_Impl

class ZEC_App: App()
{
    override val settingsApi = ZEC_SettingsAPI_Impl() //DI injected
}