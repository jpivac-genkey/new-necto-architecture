package com.genkey.zec.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_common.domain.Contact
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IContact
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IIdContact


class ZEC_Contact(
    id: UUID,
    contactType: IContact.ContactType,
    contactInfo: String,
    isPrimary: Boolean,
    val zecField1: Int, // <----------------- new field !!!!!
    val zecField2: String,// <----------------- new field !!!!!
): Contact(
    id, contactType, contactInfo, isPrimary
)
{
    constructor(contact:IIdContact, zecField1: Int, zecField2: String): this(
        contact.id,
        contact.contactType,
        contact.contactInfo,
        contact.isPrimary,
        zecField1,
        zecField2)
}
