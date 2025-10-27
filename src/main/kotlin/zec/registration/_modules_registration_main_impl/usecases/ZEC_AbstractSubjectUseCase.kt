package com.genkey.zec.registration._modules_registration_main_impl.usecases

import com.genkey.common.modules.d_signature.module_signature_api.SignatureAPI
import com.genkey.common.modules.document.module_document_api.DocumentAPI
import com.genkey.common.modules.registration._modules_registration_common.repo.RegistrationRepository
import com.genkey.common.modules.registration._modules_registration_main_impl.components.SummaryView
import com.genkey.common.modules.registration._modules_registration_main_impl.usecases.AbstractSubjectUseCase
import com.genkey.common.modules.registration.modules_registration_biographic_api.ContactsEditor
import com.genkey.zec.d_signature.module_signature_impl.usecases.ZEC_SignatureAPI_Impl
import com.genkey.zec.document.module_document_impl.ZEC_DocumentAPI_Impl
import com.genkey.zec.registration._modules_registration_common.repo.dbase.ZEC_RegistrationRepositoryImpl
import com.genkey.zec.registration._modules_registration_main_impl.components.ZEC_SummaryView
import com.genkey.zec.registration.modules_registration_biographic_impl.ZEC_ContactsEditor

/**
 * ACTUALLY THERE IS NO NEED FOR THIS CLASS
 * I JUST WANTED TO SHOW WHAT DI WILL INJECT IN THE BASIC 'AbstractSubjectUseCase' CLASS
 *
 */
abstract class ZEC_AbstractSubjectUseCase:AbstractSubjectUseCase()
{
    override val registrationRepository : RegistrationRepository = ZEC_RegistrationRepositoryImpl() //inserted by DI, singleton
    override val contactsEditor : ContactsEditor = ZEC_ContactsEditor() //inserted by DI, singleton
    override val signatureAPI : SignatureAPI = ZEC_SignatureAPI_Impl() //inserted by DI, singleton
    override val documentAPI: DocumentAPI = ZEC_DocumentAPI_Impl() //inserted by DI, singleton
    override val summaryView : SummaryView = ZEC_SummaryView() //inserted by DI, singleton
}
