package com.genkey.common.modules.registration._modules_registration_common.domain

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
    /*
    The enums DocumentFormat, DocumentPage and CaptureMethod are not defined here,
    because we have a special module dealing with capturing documents, and it returns its own classes
    (DocumentAPI.Document) which share all the same enums.
    Having practically same enums in the both classes and making conversion between them would be
    impractical.So I decided to externalize
    */

    companion object
    {
        fun createFrom(_document: DocumentAPI.Document): Document
        {
            val documentPages : List<DocumentPage> = _document.pages.map {
                DocumentPage(id = UUID.UNASSIGNED,
                    pageCode = it.pageCode,
                    pageNumber = it.pageNumber,
                    image = Image.createFrom(imageBytes = it.image))
            }

            val document = Document(
                id = UUID.UNASSIGNED,
                documentType = _document.documentType,
                documentNumber = _document.documentNumber,
                documentFormat = _document.documentFormat,
                pages =  documentPages,
                captureDate =  _document.captureDate,
                captureMethod = _document.captureMethod)

            return document
        }
    }

    fun convert(): DocumentAPI.Document
    {
        val documentPages : List<DocumentAPI.DocumentPage> = this.pages.map {
            DocumentAPI.DocumentPage(
                pageCode = it.pageCode,
                pageNumber = it.pageNumber,
                image = it.image.imageBytes)
        }

        val document = DocumentAPI.Document(
            documentType = this.documentType,
            documentNumber = this.documentNumber,
            documentFormat = this.documentFormat,
            pages =  documentPages,
            captureDate =  this.captureDate,
            captureMethod = this.captureMethod)

        return document
    }
}


