package com.genkey.common.modules.document.module_document_api

import com.genkey.common.modules.basic.Composable
import java.util.*


interface  DocumentAPI
{
    @Composable
    suspend fun captureDocuments(): List<IDocument>

    suspend fun updateDocuments(existing:List<IDocument>): List<IDocument>

    interface IDocument {
        val documentType: DocumentType
        val documentNumber: String?
        val documentFormat: DocumentFormat?
        val pages: List<IDocumentPage>
        val captureDate: Date
        val captureMethod: CaptureMethod?
    }

    interface IDocumentPage {
        val pageCode: String?
        val pageNumber: Int
        val image: ByteArray
    }

    enum class DocumentType {
        BIRTH_CERTIFICATE,
        DISABILITY_CERTIFICATE,
        REGISTRATION_REPORT,
        DRIVER_LICENSE,
        ID_CARD,
        OTHER,
        PASSPORT,
        AFFIDAVIT,
        POLICE_REPORT,
        BIRTH_NOTIFICATION_CARD,
        REGISTRATION_DOCUMENTS,
        REGISTRATION_UPDATE,
        REGISTRATION_TRANSFER,
        SIGNATURE,
        RECEIPT,
        GK_INTERNAL,
        INSURANCE_CARD,
        REFUGEE_ID,
        CIVIL_SERVICE_ID,

        ADMINISTRATIVE_CERTIFICATE,
        SUBSTITUTE_CERTIFICATE,
        VOLUNTEER_CONTRACT,
        AGENT_EMPLOYMENT_CONTRACT_PTF,
        ADMINISTRATIVE_ACT_ASSIGNMENT,
        CHECK_IN,
        DIPLOMAS_CERTIFICATE,
        PROOF_OF_ABSENCE,
        FACILITY_PHOTO,
        RESIDENCE_CERTIFICATE,
        COPY_ADM_SUB_VOL_EMP,
        COPY_ADM_ACT,
        SUPP_DOC_FOR_ABSENCE
    }

    enum class DocumentFormat {
        DOC,
        IMAGE,
        OTHER,
        PDF,
        XML
    }

    enum class CaptureMethod {
        CAPTURE
    }

}



