package com.genkey.common.modules.registration.modules_registration_biographic_impl

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_common.domain.Contact
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IContact
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IIdContact
import com.genkey.common.modules.registration.modules_registration_biographic_api.ContactsEditor

open class ContactsEditor_Impl: ContactsEditor
{
    @Composable
    override suspend fun createNew(): List<IIdContact>
    {
        val contact1 = createSingleContact()
        val contact2 = createSingleContact()
        return listOf(contact1, contact2)
    }

    protected open suspend fun createSingleContact():IIdContact
    {
        //show empty fields
        fillFieldsWithContact(null)

        //wait until user fills them

        val contact = collectFromFields(UUID.UNASSIGNED)
        return contact
    }





    @Composable
    override suspend fun update(contacts: List<IIdContact>): List<IIdContact>
    {
        val updatedContact1 = updateSingleContact(contacts.get(0))
        val updatedContact2 = updateSingleContact(contacts.get(1))
        return listOf(updatedContact1, updatedContact2)
    }

    protected open suspend fun updateSingleContact(existingContact: IIdContact):IIdContact
    {
        //fill the fields with the values from the existing contact
        fillFieldsWithContact(existingContact)

        //wait until user fills them

        val updatedContact = collectFromFields(existingContact.id)
        return updatedContact
    }

    protected open fun fillFieldsWithContact(contact: IIdContact?)
    {
        contact?.let {
            showInGUIControl(contact.contactType)
            showInGUIControl(contact.contactInfo)
            showInGUIControl(contact.isPrimary)
        }
    }

    protected open fun collectFromFields(uuid:UUID): IIdContact
    {
        val contactType =  collectFromGUIControl() as IContact.ContactType
        val contactInfo =  collectFromGUIControl() as String
        val isPrimary   =  collectFromGUIControl() as Boolean
        return Contact(uuid, contactType, contactInfo, isPrimary)
    }

    protected fun showInGUIControl(value:Any)
    {
        TODO()
    }

    protected  fun collectFromGUIControl():Any
    {
        TODO()
    }

    @Composable
    override suspend fun showSummary(contacts: List<IIdContact>)
    {
        contacts.forEach {
            showSingleContact(it)
        }
    }

    @Composable
    protected open fun showSingleContact(contact: IIdContact)
    {
        TODO()
    }

}