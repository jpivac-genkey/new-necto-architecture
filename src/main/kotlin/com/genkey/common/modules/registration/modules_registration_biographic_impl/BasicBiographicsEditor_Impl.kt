package com.genkey.common.modules.registration.modules_registration_biographic_impl

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.registration._modules_registration_common.domain.Biographics.BasicBiographics
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IBiographics
import com.genkey.common.modules.registration.modules_registration_biographic_api.BasicBiographicsEditor

open class BasicBiographicsEditor_Impl: BasicBiographicsEditor
{
    @Composable
    override suspend fun createNew(): IBiographics.IBasicBiographics
    {
        TODO("Not yet implemented")
    }

    @Composable
    override suspend fun update(type: IBiographics.IBasicBiographics): IBiographics.IBasicBiographics
    {
        TODO("Not yet implemented")
    }

    override suspend fun showSummary(type: IBiographics.IBasicBiographics)
    {
        TODO("Not yet implemented")
    }

}