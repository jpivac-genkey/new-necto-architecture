package com.genkey.zec.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.document.module_document_api.DocumentAPI.*
import com.genkey.common.modules.registration._modules_registration_common.domain.Document
import com.genkey.common.modules.registration._modules_registration_common.domain.IIdDocument
import com.genkey.zec.modules.document.module_document_api.ZEC_DocumentAPI
import com.genkey.zec.modules.registration._modules_registration_common.interfaces.IIdZEC_Document
import com.genkey.zec.modules.registration._modules_registration_common.interfaces.IIdZEC_DocumentPage
import java.util.*

data class ZEC_Document private constructor (
    private val doc: Document,
    override val zecField2:Int
): IIdDocument by doc, IIdZEC_Document
{
    override val pages = doc.pages as List<IIdZEC_DocumentPage>

    //used by Repository with the data read from the dbase
    constructor(id: UUID,
                documentType: DocumentType,
                documentNumber: String? = null,
                documentFormat: DocumentFormat? = null,
                pages: List<IIdZEC_DocumentPage>,
                captureDate: Date,
                captureMethod: CaptureMethod? = null,
                zecField2:Int): this(
        Document(id, documentType, documentNumber, documentFormat, pages, captureDate, captureMethod),
        zecField2,
        )

    //used for receiving the output from Document module
    constructor(_zec_document: ZEC_DocumentAPI.IZEC_Document): this(
        UUID.UNASSIGNED,
        _zec_document.documentType,
        _zec_document.documentNumber,
        _zec_document.documentFormat,
        _zec_document.pages.map { ZEC_DocumentPage(UUID.UNASSIGNED, it) },
        _zec_document.captureDate,
        _zec_document.captureMethod,
        _zec_document.zecField2)
}
