package com.genkey.zec.modules.registration.modules_registration_biographic_impl

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_common.domain.Contact
import com.genkey.common.modules.registration.modules_registration_biographic_impl.ContactsEditor_Impl
import com.genkey.zec.modules.registration._modules_registration_common.domain.ZEC_Contact

class ZEC_ContactsEditor : ContactsEditor_Impl()
{
    override fun fillFieldsWithContact(contact: Contact?)
    {
        super.fillFieldsWithContact(contact)
        contact?.let {
            showInGUIControl((contact as ZEC_Contact).zecField1)
            showInGUIControl((contact as ZEC_Contact).zecField2)
        }
    }

    override fun collectFromFields(uuid: UUID): ZEC_Contact
    {
        val updatedContact = super.collectFromFields(uuid)
        val zecField1 = collectFromGUIControl() as Int
        val zecField2 = collectFromGUIControl() as String
        return ZEC_Contact(updatedContact, zecField1, zecField2)
    }

    @Composable
    override fun showSingleContact(contact: Contact)
    {
        super.showSingleContact(contact)

        (contact as ZEC_Contact).zecField1 //show this field
        (contact as ZEC_Contact).zecField2 //show this field
    }

}