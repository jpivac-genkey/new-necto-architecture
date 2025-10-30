package com.genkey.common.modules.registration.modules_registration_synch_impl.repo

import com.genkey.common.modules.basic.RepoResultState
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IIdSubject
import kotlinx.coroutines.flow.Flow

interface SyncRepository
{
    fun getNotSyncedSubjects(): NotSyncedSubjects

    interface NotSyncedSubjects
    {
        val totalCount: RepoResultState<Int>
        fun getSubjects(fromIndex:Int, toIndex:Int): Flow<RepoResultState<List<IIdSubject>>>
    }

    fun markAsSynced(subject: IIdSubject): RepoResultState<Unit>
    //or maybe this:  fun markAsSynced(subjectId: UUID):ResultState<Unit>

}