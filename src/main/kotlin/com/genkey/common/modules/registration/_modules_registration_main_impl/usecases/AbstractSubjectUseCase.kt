package com.genkey.common.modules.registration._modules_registration_main_impl.usecases

import com.genkey.common.modules.d_signature.module_signature_api.SignatureAPI
import com.genkey.common.modules.d_signature.module_signature_impl.SignatureAPI_Impl
import com.genkey.common.modules.document.module_document_api.DocumentAPI
import com.genkey.common.modules.document.module_document_impl.DocumentAPI_Impl
import com.genkey.common.modules.face.module_face_capture_api.FaceCaptureAPI
import com.genkey.common.modules.face.module_face_capture_impl.FaceCaptureAPI_Impl
import com.genkey.common.modules.fingerprints.module_fingerprints_capture_api.FPCaptureAPI
import com.genkey.common.modules.fingerprints.module_fingerprints_capture_impl.FPCaptureAPI_Impl
import com.genkey.common.modules.registration._modules_registration_main_impl.repo.RegistrationRepository
import com.genkey.common.modules.registration._modules_registration_main_impl.repo.dbase.RegistrationRepositoryImpl
import com.genkey.common.modules.registration._modules_registration_main_impl.components.SummaryView
import com.genkey.common.modules.registration.modules_registration_biographic_api.*
import com.genkey.common.modules.registration.modules_registration_biographic_impl.*


abstract class AbstractSubjectUseCase()
{
    protected open val registrationRepository : RegistrationRepository = RegistrationRepositoryImpl() //inserted by DI, singleton

    protected open val basicBiographicsEditor : BasicBiographicsEditor = BasicBiographicsEditor_Impl() //inserted by DI, singleton
    protected open val disabilitiesEditor : DisabilitiesEditor = DisabilitiesEditor_Impl() //inserted by DI, singleton
    protected open val citizenshipEditor : CitizenshipEditor = CitizenshipEditor_Impl() //inserted by DI, singleton
    protected open val contactsEditor : ContactsEditor = ContactsEditor_Impl() //inserted by DI, singleton
    protected open val addressEditor : AddressEditor = AddressEditor_Impl() //inserted by DI, singleton

    protected open val faceCaptureAPI : FaceCaptureAPI = FaceCaptureAPI_Impl() //inserted by DI, singleton
    protected open val fpCaptureAPI : FPCaptureAPI = FPCaptureAPI_Impl() //inserted by DI, singleton

    protected open val documentAPI : DocumentAPI = DocumentAPI_Impl() //inserted by DI, singleton
    protected open val signatureAPI : SignatureAPI = SignatureAPI_Impl() //inserted by DI, singleton
    protected open val summaryView : SummaryView = SummaryView() //inserted by DI, singleton
}
