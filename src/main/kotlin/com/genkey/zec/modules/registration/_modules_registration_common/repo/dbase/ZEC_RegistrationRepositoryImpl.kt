package com.genkey.zec.modules.registration._modules_registration_common.repo.dbase

import com.genkey.common.modules.basic.RepoResultState
import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_common.domain.Subject
import com.genkey.common.modules.registration._modules_registration_common.repo.RegistrationRepository
import com.genkey.zec.modules.registration._modules_registration_common.domain.ZEC_Subject

class  ZEC_RegistrationRepositoryImpl: RegistrationRepository
{
    override fun readSubject(subjectID: UUID): RepoResultState<ZEC_Subject>
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

