package com.genkey.common.modules.registration._modules_registration_common.repo.dbase

import com.genkey.common.modules.basic.RepoResultState
import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_common.domain.Subject
import com.genkey.common.modules.registration._modules_registration_common.repo.RegistrationRepository
import com.genkey.common.modules.registration._modules_registration_common.repo.SubjectReadRepository
import com.genkey.common.modules.registration._modules_registration_common.repo.SubjectSaveRepository

class  RegistrationRepositoryImpl: SubjectReadRepository by SubjectReadRepositoryImpl(),
                                   SubjectSaveRepository by SubjectSaveRepositoryImpl(),
                                   RegistrationRepository

open class  SubjectReadRepositoryImpl: SubjectReadRepository
{
    override fun readSubject(subjectID: UUID): RepoResultState<Subject>
    {
        TODO("Not yet implemented")
    }
}


open class  SubjectSaveRepositoryImpl: SubjectSaveRepository
{
    override fun saveSubject(subject: Subject): RepoResultState<Unit>
    {
        TODO("Not yet implemented")
    }

    override fun markAsUpdated(subject: Subject): RepoResultState<Unit>
    {
        TODO("Not yet implemented")
    }
}