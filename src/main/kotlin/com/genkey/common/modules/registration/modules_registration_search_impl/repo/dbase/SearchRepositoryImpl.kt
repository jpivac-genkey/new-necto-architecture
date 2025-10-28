package com.genkey.common.modules.registration.modules_registration_search_impl.repo.dbase

import com.genkey.common.modules.basic.RepoResultState
import com.genkey.common.modules.registration.modules_registration_search_impl.domain.Criteria
import com.genkey.common.modules.registration.modules_registration_search_impl.repo.SearchRepository

class SearchRepositoryImpl : SearchRepository
{
    override fun search(criteria: Criteria): RepoResultState<SearchRepository.SearchResult>
    {
        TODO("Not yet implemented")
    }
}
