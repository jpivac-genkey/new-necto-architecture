package com.genkey.common.modules.registration.modules_registration_search_impl.repo

import com.genkey.common.modules.basic.RepoResultState
import com.genkey.common.modules.registration._modules_registration_common.repo.SubjectReadRepository
import com.genkey.common.modules.registration.modules_registration_search_impl.domain.Criteria
import com.genkey.common.modules.registration.modules_registration_search_impl.domain.SearchInfo
import kotlinx.coroutines.flow.Flow

/**
 * Maybe this approach????
 *
 * Here we do not know the total number of rows to be returned, but just fetch batch by bach until the whole
 * result set is reached.
 */
interface SearchRepository2: SubjectReadRepository
{
    fun search(criteria: Criteria): RepoResultState<SearchResult>

    interface SearchResult
    {
        fun getNextSearchInfos(count:Int): Flow<RepoResultState<List<SearchInfo>>>
    }
}