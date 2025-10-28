package com.genkey.zec.modules.settings.module_settings_impl.usecases

import com.genkey.common.modules.settings.module_settings_api.SettingsAPI
import com.genkey.common.modules.settings.module_settings_impl.repo.SettingsRepository
import com.genkey.common.modules.settings.module_settings_impl.usecases.EditSettings_usecase
import com.genkey.zec.modules.settings.module_settings_api.ZEC_SettingsAPI
import java.util.*

class ZEC_EditSettings_usecase(
    settingsRepository: SettingsRepository )
    :EditSettings_usecase(settingsRepository)
{
    override fun fillFieldsWithSettings(settings: SettingsAPI.Settings)
    {
        super.fillFieldsWithSettings(settings)

        val zecField1= (settings as ZEC_SettingsAPI.ZEC_Settings).zecField1
        val zecField2= (settings as ZEC_SettingsAPI.ZEC_Settings).zecField2

        //now show these additional two values
    }

    override fun createSettingsFromFields():SettingsAPI.Settings
    {
        //read the edited values from the screen
        val settingsFromFields = super.createSettingsFromFields()

        //read the additional two fields
        val zecField1 = Date()
        val zecField2 = ""

        return ZEC_SettingsAPI.ZEC_Settings(settingsFromFields, zecField1, zecField2)
    }

}