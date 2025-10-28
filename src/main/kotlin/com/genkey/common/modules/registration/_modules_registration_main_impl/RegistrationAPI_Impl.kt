package com.genkey.common.modules.registration._modules_registration_main_impl

import com.genkey.common.modules.basic.AbstractModuleComp
import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.registration._modules_registration_main_api.RegistrationAPI
import com.genkey.common.modules.registration._modules_registration_main_impl.usecases.AddNewSubject_usecase
import com.genkey.common.modules.registration._modules_registration_main_impl.usecases.ComingHome_usecase
import com.genkey.common.modules.registration._modules_registration_main_impl.usecases.SearchAndUpdateSubject_usecase

open class RegistrationAPI_Impl: AbstractModuleComp(), RegistrationAPI
{
    protected open val addNewSubject_usecase = AddNewSubject_usecase()
    protected open val searchAndUpdateSubject_usecase = SearchAndUpdateSubject_usecase()

    @Composable
    override suspend fun addNewSubject()
    {
        addNewSubject_usecase.perform()
    }

    @Composable
    override suspend fun updateSubject()
    {
        searchAndUpdateSubject_usecase.perform()
    }

    @Composable
    override suspend fun doComingHome()
    {
        ComingHome_usecase().perform()
    }

}