package com.genkey.zec.registration._modules_registration_common.repo.dbase

import com.genkey.common.modules.basic.RepoResultState
import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_common.domain.Subject
import com.genkey.common.modules.registration._modules_registration_common.repo.RegistrationRepository

class  ZEC_RegistrationRepositoryImpl: RegistrationRepository
{
    override fun readSubject(subjectID: UUID): RepoResultState<Subject>
    {
        TODO("Not yet implemented")
    }

    override fun saveSubject(subject: Subject): RepoResultState<Unit>
    {
        TODO("Not yet implemented")
    }

    override fun markAsUpdated(subject: Subject): RepoResultState<Unit>
    {
        TODO("Not yet implemented")
    }
}

