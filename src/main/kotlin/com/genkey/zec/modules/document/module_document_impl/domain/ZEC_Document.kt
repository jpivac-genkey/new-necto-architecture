package com.genkey.zec.modules.document.module_document_impl.domain

import com.genkey.common.modules.document.module_document_api.DocumentAPI.*
import com.genkey.common.modules.document.module_document_impl.domain.Document
import com.genkey.zec.modules.document.module_document_api.ZEC_DocumentAPI
import java.util.*

class ZEC_Document(
                   documentType: DocumentType,
                   documentNumber: String? = null,
                   documentFormat: DocumentFormat? = null,
                   override val pages: List<ZEC_DocumentPage>,
                   captureDate: Date,
                   captureMethod: CaptureMethod? = null,
                   override val zecField2:Int):
    Document(documentType, documentNumber, documentFormat, pages, captureDate, captureMethod)
    ,ZEC_DocumentAPI.IZEC_Document
