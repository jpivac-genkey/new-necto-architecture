package com.genkey.common.modules.registration.modules_registration_search_impl.domain

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_common.domain.Biographics
import com.genkey.common.modules.registration._modules_registration_common.domain.Image
import java.util.Date

class SearchInfo (
    val subjectId: UUID,
    val registrationDate: Date,
    val firstName: String,
    val lastName: String,
    val gender: Biographics.Gender,
    val dateOfBirth: Date,
    val nationalID: String,
    val image: Image
    )
