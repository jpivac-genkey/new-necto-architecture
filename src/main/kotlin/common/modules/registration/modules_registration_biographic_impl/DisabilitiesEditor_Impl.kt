package com.genkey.common.modules.registration.modules_registration_biographic_impl

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.registration._modules_registration_common.domain.Disability
import com.genkey.common.modules.registration.modules_registration_biographic_api.DisabilitiesEditor

//this is just a GUI component (it can be a part of the screen or a  whole screen)
open class DisabilitiesEditor_Impl: DisabilitiesEditor
{
    @Composable
    override suspend fun createNew(): List<Disability>
    {
        TODO("Not yet implemented")
    }

    @Composable
    override suspend fun update(disabilities:List<Disability>): List<Disability>
    {
        TODO("Not yet implemented")
    }

    override suspend fun showSummary(type: List<Disability>)
    {
        TODO("Not yet implemented")
    }
}