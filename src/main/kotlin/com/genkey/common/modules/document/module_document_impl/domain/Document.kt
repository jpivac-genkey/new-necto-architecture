package com.genkey.common.modules.document.module_document_impl.domain

import com.genkey.common.modules.document.module_document_api.DocumentAPI
import java.util.*

open class Document(
    override val documentType: DocumentAPI.DocumentType,
    override val documentNumber: String?,
    override val documentFormat: DocumentAPI.DocumentFormat?,
    override val pages: List<DocumentAPI.IDocumentPage>,
    override val captureDate: Date,
    override val captureMethod: DocumentAPI.CaptureMethod?,
): DocumentAPI.IDocument



