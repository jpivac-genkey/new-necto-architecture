package com.genkey.common.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.document.module_document_api.DocumentAPI
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IHavingID

/*
CREATE TABLE public.documents_pages (
	id uuid NOT NULL,
	page_code varchar(32) NULL,
	page_number int4 NOT NULL,
	image_id uuid NOT NULL,
	document_profile_id uuid NOT NULL,
	CONSTRAINT pk_documents_pages PRIMARY KEY (id),
	CONSTRAINT fk_documents_pages_document_profiles FOREIGN KEY (document_profile_id) REFERENCES public.documents_profiles(id),
	CONSTRAINT fk_documents_pages_images FOREIGN KEY (image_id) REFERENCES public.images(id)
);
 */
/**
 * document_profile_id is removed, since this class's belonging to a subject is expressed in another way.
 * "id" is here just for update when this object is to be written to the exactly same row in the dbase
 * In case of creation of a new object, the id is assigned a 'UUID.UNASSIGNED' value, since that object
 * has never been in the dbase.
 */

interface IIdDocumentPage: DocumentAPI.IDocumentPage, IHavingID

data class DocumentPage(
    override val id: UUID,
    override val pageCode: String? = null,
    override val pageNumber: Int,
    override val image: ByteArray
):IIdDocumentPage
{
    //used for receiving the output from Document module
    constructor(_documentPage: DocumentAPI.IDocumentPage ):this(
        UUID.UNASSIGNED,
        _documentPage.pageCode,
        _documentPage.pageNumber,
        _documentPage.image
    )
}
