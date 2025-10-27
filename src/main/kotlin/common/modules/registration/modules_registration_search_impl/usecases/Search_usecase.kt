package com.genkey.common.modules.registration.modules_registration_search_impl.usecases

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration.modules_registration_search_impl.domain.Criteria
import com.genkey.common.modules.registration.modules_registration_search_impl.repo.SearchRepository
import com.genkey.common.modules.registration.modules_registration_search_impl.repo.dbase.SearchRepositoryImpl

class Search_usecase
{
    val searchRepository: SearchRepository = SearchRepositoryImpl() //DI injected, singleton

    @Composable
    suspend fun showCriteriaFieldsAndReturnSelected(): UUID
    {
        val criteria = showCriteriaFields()
        return showFoundSubjectInfos(criteria)
    }

    @Composable
    private suspend fun showCriteriaFields(): Criteria
    {
        TODO("Not yet implemented")
    }

    @Composable
    private suspend fun showFoundSubjectInfos(criteria: Criteria): UUID
    {
        searchRepository.search(criteria)

        TODO("Not yet implemented")
    }
}