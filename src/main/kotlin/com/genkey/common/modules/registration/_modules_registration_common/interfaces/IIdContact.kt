package com.genkey.common.modules.registration._modules_registration_common.interfaces

interface IIdContact: IContact, IHavingID

interface IContact
{
    val contactType: ContactType
    val contactInfo: String
    val isPrimary: Boolean

    enum class ContactType
    {
        PHONE,
        EMAIl
    }
}