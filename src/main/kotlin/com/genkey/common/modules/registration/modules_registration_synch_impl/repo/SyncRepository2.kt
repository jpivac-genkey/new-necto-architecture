package com.genkey.common.modules.registration.modules_registration_synch_impl.repo

import com.genkey.common.modules.registration._modules_registration_domain.Subject
import com.genkey.common.modules.basic.RepoResultState
import com.genkey.common.modules.basic.UUID
import kotlinx.coroutines.flow.Flow

/**
 * Another possible approach where you do not first get the number of subjects to be synchronized, but just fetch
 * and fetch until you exhaust all those subjects
 */
interface SyncRepository2
{
    fun getNotSyncedSubjects(): NotSyncedSubjects

    interface NotSyncedSubjects
    {
        fun getNextSubjects(count:Int): Flow<RepoResultState<List<UUID>>>
    }

    fun markAsSynced(subjectID: UUID): RepoResultState<Unit>
    //or maybe this:  fun markAsSynced(subjectId: UUID):ResultState<Unit>
}