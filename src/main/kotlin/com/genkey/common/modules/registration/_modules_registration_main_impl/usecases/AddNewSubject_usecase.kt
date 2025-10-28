package com.genkey.common.modules.registration._modules_registration_main_impl.usecases

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_domain.*
import java.util.*

class AddNewSubject_usecase : AbstractSubjectUseCase()
{
    @Composable
    open suspend fun perform()
    {
        val registrationDate: Date = Date()

        val basicBiographics: Biographics.BasicBiographics = basicBiographicsEditor.createNew()
        val address: Address = addressEditor.createNew()
        val contacts:List<Contact> = contactsEditor.createNew()
        val citizenship: Citizenship = citizenshipEditor.createNew()
        val disabilities:List<Disability> = disabilitiesEditor.createNew()

        val _face = faceCaptureAPI.captureNewFace()
        val face = Face.createFrom(_face)

        val _fingerPrints = fpCaptureAPI.captureNewFingerPrints()
        val fingerPrints: FingerPrints = FingerPrints.createFrom(_fingerPrints)

        val signature : Signature = signatureAPI.captureSignature()
        val documents: List<Document> = documentAPI.captureDocuments()

        val biographics = Biographics(basicBiographics,citizenship, disabilities,address, contacts)
        val subject = Subject(
            UUID(),registrationDate, biographics, Biometrics( face, fingerPrints), signature, documents)

        summaryView.showAll(subject)

        registrationRepository.saveSubject(subject)
    }
}