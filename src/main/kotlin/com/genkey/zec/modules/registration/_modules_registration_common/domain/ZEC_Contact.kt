package com.genkey.zec.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_common.domain.Contact


class ZEC_Contact(
    id: UUID,
    contactType: Contact.ContactType,
    contactInfo: String,
    isPrimary: Boolean,
    val zecField1: Int, // <----------------- new field !!!!!
    val zecField2: String,// <----------------- new field !!!!!
): Contact(id, contactType, contactInfo, isPrimary)
{
    constructor(contact:Contact, zecField1: Int, zecField2: String): this(
        contact.id,
        contact.contactType,
        contact.contactInfo,
        contact.isPrimary,
        zecField1,
        zecField2)
}
