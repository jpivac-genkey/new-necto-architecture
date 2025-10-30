package com.genkey.common.modules.registration.modules_registration_biographic_impl

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IIdCitizenship
import com.genkey.common.modules.registration.modules_registration_biographic_api.CitizenshipEditor


open class CitizenshipEditor_Impl: CitizenshipEditor
{
    @Composable
    override suspend fun createNew(): IIdCitizenship
    {
        TODO("Not yet implemented")
    }

    @Composable
    override suspend fun update(type: IIdCitizenship): IIdCitizenship
    {
        TODO("Not yet implemented")
    }

    override suspend fun showSummary(type: IIdCitizenship)
    {
        TODO("Not yet implemented")
    }
}