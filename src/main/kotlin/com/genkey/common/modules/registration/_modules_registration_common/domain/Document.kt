package com.genkey.common.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.document.module_document_api.DocumentAPI
import com.genkey.common.modules.document.module_document_api.DocumentAPI.*
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IHavingID
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

interface IIdDocument: DocumentAPI.IDocument, IHavingID

data class Document(
    override val id: UUID,
    override val documentType: DocumentType,
    override val documentNumber: String? = null,
    override val documentFormat: DocumentFormat? = null,
    override val pages: List<IIdDocumentPage>,
    override val captureDate: Date,
    override val captureMethod: CaptureMethod? = null
):IIdDocument
{
    //used for receiving the output from Document module
    constructor(_document:DocumentAPI.IDocument): this(
        UUID.UNASSIGNED,
        _document.documentType,
        _document.documentNumber,
        _document.documentFormat,
        _document.pages.map { DocumentPage(it) },
        _document.captureDate,
        _document.captureMethod)
}



