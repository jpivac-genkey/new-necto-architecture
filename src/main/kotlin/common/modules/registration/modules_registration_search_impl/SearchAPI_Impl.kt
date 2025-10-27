package com.genkey.common.modules.registration.modules_registration_search_impl

import com.genkey.common.modules.basic.AbstractModuleComp
import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration.modules_registration_search_api.SearchAPI
import com.genkey.common.modules.registration.modules_registration_search_impl.repo.dbase.SearchRepositoryImpl
import com.genkey.common.modules.registration.modules_registration_search_impl.usecases.Search_usecase

class SearchAPI_Impl : AbstractModuleComp(), SearchAPI
{
    private val searchRepository = SearchRepositoryImpl() //DI injected, singleton

    @Composable
    override suspend fun performSearch():UUID?
    {
        val selectedSubjectUuid = Search_usecase().showCriteriaFieldsAndReturnSelected()
        return selectedSubjectUuid
    }

}