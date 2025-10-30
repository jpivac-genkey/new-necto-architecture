package com.genkey.common.modules.registration.modules_registration_biographic_impl

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.registration._modules_registration_common.domain.Address
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IIdAddress
import com.genkey.common.modules.registration.modules_registration_biographic_api.AddressEditor

open class AddressEditor_Impl: AddressEditor
{
    @Composable
    override suspend fun createNew(): IIdAddress
    {
        TODO("Not yet implemented")
    }

    @Composable
    override suspend fun update(type: IIdAddress): IIdAddress
    {
        TODO("Not yet implemented")
    }

    @Composable
    override suspend fun showSummary(type: IIdAddress)
    {
        TODO("Not yet implemented")
    }
}