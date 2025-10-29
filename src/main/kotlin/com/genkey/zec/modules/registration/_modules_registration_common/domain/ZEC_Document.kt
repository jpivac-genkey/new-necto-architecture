package com.genkey.zec.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.document.module_document_api.DocumentAPI.*
import com.genkey.common.modules.registration._modules_registration_common.domain.Document
import com.genkey.common.modules.registration._modules_registration_common.domain.DocumentPage
import com.genkey.common.modules.registration._modules_registration_common.domain.IIdDocument
import com.genkey.common.modules.registration._modules_registration_common.domain.IIdDocumentPage
import com.genkey.zec.modules.document.module_document_api.ZEC_DocumentAPI
import java.util.*


data class ZEC_Document private constructor (
    private val doc: Document,
    override val zecField2:Int
): IIdDocument by doc, ZEC_DocumentAPI.IZEC_Document
{
    constructor(id: UUID,
                documentType: DocumentType,
                documentNumber: String? = null,
                documentFormat: DocumentFormat? = null,
                pages: List<IIdDocumentPage>,
                captureDate: Date,
                captureMethod: CaptureMethod? = null,
                zecField2:Int): this(
        Document(id, documentType, documentNumber, documentFormat, pages, captureDate, captureMethod),
        zecField2)

    constructor(_zec_document: ZEC_DocumentAPI.IZEC_Document): this(
        UUID.UNASSIGNED,
        _zec_document.documentType,
        _zec_document.documentNumber,
        _zec_document.documentFormat,
        _zec_document.pages.map { DocumentPage(it) },
        _zec_document.captureDate,
        _zec_document.captureMethod)
}
