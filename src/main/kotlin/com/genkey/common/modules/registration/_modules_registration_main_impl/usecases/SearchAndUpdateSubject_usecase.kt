package com.genkey.common.modules.registration._modules_registration_main_impl.usecases

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.basic.RepoResultState
import com.genkey.common.modules.face.module_face_verify_api.FaceVerificationAPI
import com.genkey.common.modules.face.module_face_verify_impl.FaceVerificationAPI_Impl
import com.genkey.common.modules.fingerprints.module_fingerprints_verify_api.FPVerificationAPI
import com.genkey.common.modules.fingerprints.module_fingerprints_verify_impl.FPVerificationAPI_Impl
import com.genkey.common.modules.registration._modules_registration_common.domain.*
import com.genkey.common.modules.registration.modules_registration_search_api.SearchAPI
import com.genkey.common.modules.registration.modules_registration_search_impl.SearchAPI_Impl


class SearchAndUpdateSubject_usecase : AbstractSubjectUseCase()
{
    private val searchAPI:SearchAPI = SearchAPI_Impl()

    private val faceVerificationAPI : FaceVerificationAPI = FaceVerificationAPI_Impl() //inserted by DI, singleton
    private val fpVerificationAPI : FPVerificationAPI = FPVerificationAPI_Impl() //inserted by DI, singleton

    @Composable
    suspend fun perform()
    {
        val uuidOfSubjectToBeUpdated = searchAPI.performSearch()
        if(uuidOfSubjectToBeUpdated!=null)
        {
            val readSubjectResult = registrationRepository.readSubject(uuidOfSubjectToBeUpdated)
            if(readSubjectResult is RepoResultState.Success)
            {
                val originalSubject = readSubjectResult.value
                val updatedSubject = update(originalSubject)

                registrationRepository.saveSubject(updatedSubject)
                registrationRepository.markAsUpdated(updatedSubject)
            }
        }

        TODO("Not yet implemented")
    }

    @Composable
    suspend fun update(subject: Subject): Subject
    {
        val updatedBasicBiographics: Biographics.BasicBiographics = basicBiographicsEditor.update(subject.biographics.getBasicBiographics())
        val updatedAddress: Address = addressEditor.update(subject.biographics.address!!)
        val updatedContacts:List<Contact> = contactsEditor.update(subject.biographics.contacts!!)
        val updatedCitizenship: Citizenship = citizenshipEditor.update(subject.biographics.citizenship!!)
        val updatedDisabilities:List<Disability> = disabilitiesEditor.update(subject.biographics.disabilities!!)

        val _face = faceCaptureAPI.updateFace(subject.biometrics?.face!!.convert())
        val face = Face.createFrom(_face)

        val _fingerPrints = fpCaptureAPI.updateFingerPrints(subject.biometrics.fingerPrints as FingerPrintSet.FingerPrints)
        val updatedFingerPrints: FingerPrintSet = FingerPrintSet.FingerPrints(_fingerPrints)

        val _signature = signatureAPI.updateSignature(subject.signature!!)
        val updateSignature : Signature = Signature(_signature)

        val _documents = documentAPI.updateDocuments(subject.documents!!)
        val updatedDocumens: List<Document> = _documents.map { Document(it)}

        val updatedBiographics = Biographics(
            updatedBasicBiographics,
            updatedCitizenship,
            updatedDisabilities,
            updatedAddress,
            updatedContacts)

        val updatedSubject = Subject(
            subject.id,
            subject.registrationDate,
            updatedBiographics,
            Biometrics(face,updatedFingerPrints),
            updateSignature,
            updatedDocumens)

        summaryView.showAll(subject)
        return updatedSubject
    }
}