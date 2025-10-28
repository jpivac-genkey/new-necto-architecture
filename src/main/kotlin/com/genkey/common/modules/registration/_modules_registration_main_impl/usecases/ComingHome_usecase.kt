package com.genkey.common.modules.registration._modules_registration_main_impl.usecases

import com.genkey.common.modules.basic.RepoResultState
import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_main_impl.repo.RegistrationRepository
import com.genkey.common.modules.registration._modules_registration_main_impl.repo.dbase.RegistrationRepositoryImpl
import com.genkey.common.modules.registration.modules_registration_synch_api.SynchronizationAPI
import com.genkey.common.modules.registration.modules_registration_synch_impl.SynchronizationAPI_Impl

class ComingHome_usecase
{
    private val synchronizationAPI: SynchronizationAPI = SynchronizationAPI_Impl() //DI injected
    private val registrationRepository : RegistrationRepository = RegistrationRepositoryImpl() //inserted by DI, singleton
    suspend fun perform()
    {
        val subjectProvider = {id:UUID -> (registrationRepository.readSubject(id) as RepoResultState.Success).value}
        synchronizationAPI.sendDataToSpire(subjectProvider)
    }
}