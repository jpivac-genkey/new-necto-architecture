package com.genkey.common.modules.registration.modules_registration_search_impl.repo

import com.genkey.common.modules.basic.RepoResultState
import com.genkey.common.modules.registration._modules_registration_common.repo.SubjectReadRepository
import com.genkey.common.modules.registration.modules_registration_search_impl.domain.Criteria
import com.genkey.common.modules.registration.modules_registration_search_impl.domain.SearchInfo
import kotlinx.coroutines.flow.Flow


/**
 * SearchInfo is to be filled from the full text search virtual tables. This table also gives
 * subjectIDs in the result rows. Over subjectID the facial image can be extracted from "Image" table
 * and then returned in "SearchInfo".
 *
 */
interface SearchRepository
{
    fun search(criteria: Criteria): RepoResultState<SearchResult>

    interface SearchResult
    {
        val totalCount: Int //No need for RepoResultState
        fun getSearchInfos(fromIndex:Int, toIndex:Int): Flow<RepoResultState<List<SearchInfo>>>
    }
}

