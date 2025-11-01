package com.genkey.zec.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.document.module_document_api.DocumentAPI.*
import com.genkey.common.modules.registration._modules_registration_common.domain.Document
import com.genkey.zec.modules.document.module_document_api.ZEC_DocumentAPI
import java.util.*

class ZEC_Document(id: UUID? = null,
                 documentType: DocumentType,
                 documentNumber: String? = null,
                 documentFormat: DocumentFormat? = null,
                 override val pages: List<ZEC_DocumentPage>,
                 captureDate: Date,
                 captureMethod: CaptureMethod? = null,
                 override val zecField2:Int):
    Document(id, documentType, documentNumber, documentFormat, pages, captureDate, captureMethod)
    ,ZEC_DocumentAPI.IZEC_Document
{
    //used for receiving the output from Document module
    constructor(_zec_document: ZEC_DocumentAPI.IZEC_Document): this(
        null,
        _zec_document.documentType,
        _zec_document.documentNumber,
        _zec_document.documentFormat,
        _zec_document.pages.map { ZEC_DocumentPage(null, it) },
        _zec_document.captureDate,
        _zec_document.captureMethod,
        _zec_document.zecField2)
}
