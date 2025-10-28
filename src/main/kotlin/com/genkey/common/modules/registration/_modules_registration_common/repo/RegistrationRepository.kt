package com.genkey.common.modules.registration._modules_registration_common.repo

import com.genkey.common.modules.basic.RepoResultState
import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_common.domain.Subject

interface RegistrationRepository: SubjectSaveRepository, SubjectReadRepository

interface SubjectReadRepository
{
    fun readSubject(subjectID: UUID): RepoResultState<Subject>
}

interface SubjectSaveRepository
{
    fun saveSubject(subject: Subject): RepoResultState<Unit>
    fun markAsUpdated(subject: Subject): RepoResultState<Unit>
}