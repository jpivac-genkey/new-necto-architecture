package com.genkey.common.modules.registration._modules_registration_domain

import com.genkey.common.modules.basic.*
import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.document.module_document_api.DocumentAPI
import java.util.*

/*
CREATE TABLE public.documents_profiles (
	id uuid NOT NULL,
	document_type varchar(32) NOT NULL,
	document_number varchar(32) NULL,
	document_format varchar(4) NULL,
	number_of_pages int4 NOT NULL,
	capture_date timestamptz NOT NULL,
	capture_method varchar(255) NULL,
	subject_id uuid NOT NULL,
	spire_transaction_id uuid NOT NULL,
	CONSTRAINT pk_documents_profiles PRIMARY KEY (id),
	CONSTRAINT fk_documents_profiles_spire_transactions FOREIGN KEY (spire_transaction_id) REFERENCES public.spire_transactions(id),
	CONSTRAINT fk_documents_profiles_subjects FOREIGN KEY (subject_id) REFERENCES public.subjects(id)
);
 */
/**
 * SubjectId is removed, since this class's belonging to a subject is expressed in another way.
 * "id" is here just for update when this object is to be written to the exactly same row in the dbase
 * In case of creation of a new object, the id is assigned a 'UUID.UNASSIGNED' value, since that object
 * has never been in the dbase.
 */
class Document(
    val id: UUID,
    val documentType: DocumentEnums.DocumentType,
    val documentNumber: String? = null,
    val documentFormat: DocumentEnums.DocumentFormat? = null,
    val pages: List<DocumentPage>,
    val captureDate: Date,
    val captureMethod: DocumentEnums.CaptureMethod? = null
):DocumentEnums
{
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

    }
}


