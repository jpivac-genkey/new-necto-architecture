package com.genkey.common.modules.registration.modules_registration_synch_impl.repo.dbase

import com.genkey.common.modules.basic.RepoResultState
import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_main_impl.repo.SubjectReadRepository
import com.genkey.common.modules.registration._modules_registration_main_impl.repo.dbase.SubjectReadRepositoryImpl
import com.genkey.common.modules.registration.modules_registration_synch_impl.repo.SyncRepository
import kotlinx.coroutines.flow.Flow

/*
  In the dbase there will be an additional table with these fields
  | subjectID | updateDate | synchronizedDate|

  if updateDate = null --> the subject never updated
  if synchronizedDate = null --> it should be sent to Spire

  This table is used by this repository.

  How the fields will be interpreted will be discussed.
*/

class SyncRepositoryImpl : SyncRepository
{
    private val subjectReadRepository: SubjectReadRepository = SubjectReadRepositoryImpl() //DI injected

    override fun getNotSyncedSubjects(): SyncRepository.NotSyncedSubjects
    {
        return object: SyncRepository.NotSyncedSubjects
        {
            override val totalCount: RepoResultState<Int>
                get() = TODO("Not yet implemented")

            override fun getSubjects(fromIndex: Int, toIndex: Int): Flow<RepoResultState<List<UUID>>>
            {
                TODO("Not yet implemented")
                //subjectReadRepository.readSubject(subjectID)
            }
        }
    }

    override fun markAsSynced(subjectID: UUID): RepoResultState<Unit>
    {
        TODO("Not yet implemented")
        //just set the current date in the 'synchronizedDate' column of the above-mentioned table
    }

}
