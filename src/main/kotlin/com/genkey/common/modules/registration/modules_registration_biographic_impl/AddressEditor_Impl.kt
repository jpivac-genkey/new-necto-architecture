package com.genkey.common.modules.registration.modules_registration_biographic_impl

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.registration._modules_registration_common.domain.Address
import com.genkey.common.modules.registration.modules_registration_biographic_api.AddressEditor

open class AddressEditor_Impl: AddressEditor
{
    @Composable
    override suspend fun createNew(): Address
    {
        TODO("Not yet implemented")
    }

    @Composable
    override suspend fun update(address: Address): Address
    {
        TODO("Not yet implemented")
    }

    @Composable
    override suspend fun showSummary(type: Address)
    {
        TODO("Not yet implemented")
    }
}