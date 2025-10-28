package com.genkey.zec.modules._main

import com.genkey.common.modules._main.App
import com.genkey.zec.modules.settings.module_settings_impl.ZEC_SettingsAPI_Impl

class ZEC_App: App()
{
    override val settingsApi = ZEC_SettingsAPI_Impl() //DI injected
}