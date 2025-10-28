package com.genkey.common.modules.registration.modules_registration_biographic_impl

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.registration._modules_registration_domain.Citizenship
import com.genkey.common.modules.registration.modules_registration_biographic_api.CitizenshipEditor


open class CitizenshipEditor_Impl: CitizenshipEditor
{
    @Composable
    override suspend fun createNew(): Citizenship
    {
        TODO("Not yet implemented")
    }

    @Composable
    override suspend fun update(citizenship: Citizenship): Citizenship
    {
        TODO("Not yet implemented")
    }

    override suspend fun showSummary(type: Citizenship)
    {
        TODO("Not yet implemented")
    }
}