package com.genkey.common.modules.registration._modules_registration_main_impl.components

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.registration._modules_registration_common.domain.*
import com.genkey.common.modules.registration.modules_registration_biographic_api.*
import com.genkey.common.modules.registration.modules_registration_biographic_impl.*

open class SummaryView
{
    protected open val basicBiographicsEditor : BasicBiographicsEditor = BasicBiographicsEditor_Impl() //inserted by DI, singleton
    protected open val disabilitiesEditor : DisabilitiesEditor = DisabilitiesEditor_Impl() //inserted by DI, singleton
    protected open val citizenshipEditor : CitizenshipEditor = CitizenshipEditor_Impl() //inserted by DI, singleton
    protected open val contactsEditor : ContactsEditor = ContactsEditor_Impl() //inserted by DI, singleton
    protected open val addressEditor : AddressEditor = AddressEditor_Impl() //inserted by DI, singleton

    @Composable
    suspend fun showAll(subject: Subject)
    {
        basicBiographicsEditor.showSummary(subject.biographics.getBasicBiographics())

        subject.biographics.address?.let {
            addressEditor.showSummary(it)
        }

        subject.biographics.contacts?.let {
            contactsEditor.showSummary(it)
        }

        subject.biographics.citizenship?.let {
            citizenshipEditor.showSummary(it)
        }

        subject.biographics.disabilities?.let {
            disabilitiesEditor.showSummary(it)
        }

        subject.biometrics?.fingerPrints?.let{
            showFingerPrints(it)
        }

        subject.biometrics?.face?.let{
            showFace(it)
        }

        subject.signature?.let{
            showSignature(it)
        }

        subject.documents?.let{
            showDocuments(it)
        }
    }

    protected open fun showFingerPrints(fingerPrints: FingerPrintSet)
    {

    }

    protected open fun showFace(face: Face)
    {

    }

    protected open fun showDocuments(documents: List<Document>)
    {

    }

    protected open fun showSignature(signature: Signature)
    {

    }
}