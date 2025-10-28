package com.genkey.common.modules.registration.modules_registration_synch_impl

import com.genkey.common.modules.basic.AbstractModuleComp
import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.basic.RepoResultState
import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_domain.Subject
import com.genkey.common.modules.registration.modules_registration_synch_api.SynchronizationAPI
import com.genkey.common.modules.registration.modules_registration_synch_impl.repo.dbase.SyncRepositoryImpl
import kotlinx.coroutines.flow.collect

class SynchronizationAPI_Impl : AbstractModuleComp(),SynchronizationAPI
{
    private val syncRepository = SyncRepositoryImpl() //DI injected, singleton
    private val BATCH_SIZE = 10

    @Composable
    override suspend fun sendDataToSpire(subjectProvider: (UUID) -> Subject)
    {
        val notSyncedSubjects = syncRepository.getNotSyncedSubjects()


        val totalCountResult = notSyncedSubjects.totalCount
        if(totalCountResult is RepoResultState.Success)
        {
            val batchCount = totalCountResult.value / BATCH_SIZE
            for(i in 0..batchCount-1)
            {
                val subjectsResultsFlow = notSyncedSubjects.getSubjects(i * BATCH_SIZE, (i + 1) * BATCH_SIZE)
                subjectsResultsFlow.collect { subjectResult ->
                    if(subjectResult is RepoResultState.Success)
                    {
                        val subjectIDsList = subjectResult.value

                        //send subjectsList to spire
                        val listOfSubjects = subjectIDsList.map { subjectProvider(it) }
                        listOfSubjects.forEach { subject ->  /*send to Spire*/ }

                        //mark them as synchronized
                        subjectIDsList.forEach{syncRepository.markAsSynced(it)}
                    }
                }
            }
        }

    }
}