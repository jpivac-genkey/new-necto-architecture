package com.genkey.zec.modules.document.module_document_impl.domain

import com.genkey.common.modules.document.module_document_api.DocumentAPI.*
import com.genkey.common.modules.document.module_document_impl.domain.Document
import com.genkey.zec.modules.document.module_document_api.ZEC_DocumentAPI
import java.util.*

data class ZEC_Document private constructor (
    private val doc: Document,
    override val zecField2:Int
): IDocument by doc, ZEC_DocumentAPI.IZEC_Document
{
    //the only constructor to be used
    constructor(documentType: DocumentType,
                documentNumber: String? = null,
                documentFormat: DocumentFormat? = null,
                pages: List<IDocumentPage>,
                captureDate: Date,
                captureMethod: CaptureMethod,
                zecField2:Int):
            this(
                Document(documentType, documentNumber, documentFormat, pages, captureDate, captureMethod),
                zecField2)
}