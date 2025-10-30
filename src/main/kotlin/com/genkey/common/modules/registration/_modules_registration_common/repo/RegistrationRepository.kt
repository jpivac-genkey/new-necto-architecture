package com.genkey.common.modules.registration._modules_registration_common.repo

import com.genkey.common.modules.basic.RepoResultState
import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_common.domain.Subject
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IIdSubject

interface RegistrationRepository: SubjectSaveRepository, SubjectReadRepository

interface SubjectReadRepository
{
    fun readSubject(subjectID: UUID): RepoResultState<IIdSubject>
}

interface SubjectSaveRepository
{
    fun saveSubject(subject: IIdSubject): RepoResultState<Unit>
    fun markAsUpdated(subject: IIdSubject): RepoResultState<Unit>
}