package com.genkey.common.modules.registration._modules_registration_common.interfaces

import com.genkey.common.modules.registration._modules_registration_common.domain.Address


interface IIdAddress: IAddress, IHavingID

interface IAddress
{
    val addressType: AddressType
    val country: String?
    val region: String?
    val city: String?
    val address: String
    val addressDetails: String?
    val postalCode: String?
    val demarcationEntryId: Int?

    enum class AddressType
    {
        //do we already have the values somewhere in the code?
    }
}