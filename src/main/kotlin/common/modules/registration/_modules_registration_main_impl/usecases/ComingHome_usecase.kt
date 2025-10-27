package com.genkey.common.modules.registration._modules_registration_main_impl.usecases

import com.genkey.common.modules.registration.modules_registration_synch_api.SynchronizationAPI
import com.genkey.common.modules.registration.modules_registration_synch_impl.SynchronizationAPI_Impl

class ComingHome_usecase
{
    private val synchronizationAPI: SynchronizationAPI = SynchronizationAPI_Impl() //DI injected

    suspend fun perform()
    {
        synchronizationAPI.sendDataToSpire()
    }
}