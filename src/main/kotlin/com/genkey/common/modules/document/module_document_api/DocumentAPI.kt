package com.genkey.common.modules.document.module_document_api

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.registration._modules_registration_common.domain.Disability.TraumaType
import com.genkey.common.modules.basic.ValInterface
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

    interface DocumentType: ValInterface
    interface DocumentFormat: ValInterface
    interface CaptureMethod: ValInterface

    enum class TraumaEnum(override val value: Int): TraumaType

    enum class DocumentTypeEnum(override val value: Int): DocumentType
    {
        BIRTH_CERTIFICATE(1),
        DISABILITY_CERTIFICATE(2),
        REGISTRATION_REPORT(3),
        DRIVER_LICENSE(4),
        ID_CARD(5),
        OTHER(6),
        PASSPORT(7),
        AFFIDAVIT(8),
        POLICE_REPORT(9),
        BIRTH_NOTIFICATION_CARD(10),
        REGISTRATION_DOCUMENTS(11),
        REGISTRATION_UPDATE(12),
        REGISTRATION_TRANSFER(13),
        SIGNATURE(14),
        RECEIPT(15),
        GK_INTERNAL(16),
        INSURANCE_CARD(17),
        REFUGEE_ID(18),
        CIVIL_SERVICE_ID(19),

        ADMINISTRATIVE_CERTIFICATE(20),
        SUBSTITUTE_CERTIFICATE(21),
        VOLUNTEER_CONTRACT(22),
        AGENT_EMPLOYMENT_CONTRACT_PTF(23),
        ADMINISTRATIVE_ACT_ASSIGNMENT(24),
        CHECK_IN(25),
        DIPLOMAS_CERTIFICATE(26),
        PROOF_OF_ABSENCE(27),
        FACILITY_PHOTO(28),
        RESIDENCE_CERTIFICATE(29),
        COPY_ADM_SUB_VOL_EMP(30),
        COPY_ADM_ACT(31),
        SUPP_DOC_FOR_ABSENCE(32)
    }

    enum class DocumentFormatEnum(override val value: Int): DocumentFormat
    {
        DOC(1),
        IMAGE(2),
        OTHER(3),
        PDF(4),
        XML(5)
    }

    enum class CaptureMethodEnum(override val value: Int): CaptureMethod
    {
        CAPTURE(1)
    }


}



