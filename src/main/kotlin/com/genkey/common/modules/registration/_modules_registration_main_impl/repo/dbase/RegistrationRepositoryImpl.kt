package com.genkey.common.modules.registration._modules_registration_main_impl.repo.dbase

import com.genkey.common.modules.basic.RepoResultState
import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_domain.Subject
import com.genkey.common.modules.registration._modules_registration_main_impl.repo.RegistrationRepository
import com.genkey.common.modules.registration._modules_registration_main_impl.repo.SubjectReadRepository
import com.genkey.common.modules.registration._modules_registration_main_impl.repo.SubjectSaveRepository

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