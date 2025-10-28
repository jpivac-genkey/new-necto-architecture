package com.genkey.common.modules.registration.modules_registration_biographic_impl

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.registration._modules_registration_domain.Biographics.BasicBiographics
import com.genkey.common.modules.registration.modules_registration_biographic_api.BasicBiographicsEditor

open class BasicBiographicsEditor_Impl: BasicBiographicsEditor
{
    @Composable
    override suspend fun createNew(): BasicBiographics
    {
        TODO("Not yet implemented")
    }

    @Composable
    override suspend fun update(basicBiographics: BasicBiographics): BasicBiographics
    {
        TODO("Not yet implemented")
    }

    override suspend fun showSummary(type: BasicBiographics)
    {
        TODO("Not yet implemented")
    }

}