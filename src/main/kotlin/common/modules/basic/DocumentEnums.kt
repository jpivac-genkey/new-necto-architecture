package com.genkey.common.modules.basic

//to be used only by Document related classes
interface DocumentEnums
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

