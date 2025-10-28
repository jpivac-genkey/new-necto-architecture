package com.genkey.common.modules.registration.modules_registration_synch_impl.repo

import com.genkey.common.modules.registration._modules_registration_common.domain.Subject
import com.genkey.common.modules.basic.RepoResultState
import kotlinx.coroutines.flow.Flow

interface SyncRepository
{
    fun getNotSyncedSubjects(): NotSyncedSubjects

    interface NotSyncedSubjects
    {
        val totalCount: RepoResultState<Int>
        fun getSubjects(fromIndex:Int, toIndex:Int): Flow<RepoResultState<List<Subject>>>
    }

    fun markAsSynced(subject: Subject): RepoResultState<Unit>
    //or maybe this:  fun markAsSynced(subjectId: UUID):ResultState<Unit>

}