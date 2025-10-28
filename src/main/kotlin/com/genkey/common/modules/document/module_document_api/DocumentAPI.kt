package com.genkey.common.modules.document.module_document_api

import com.genkey.common.modules.basic.*
import com.genkey.common.modules.basic.UUID
import java.util.*


interface  DocumentAPI
{
    @Composable
    suspend fun captureDocuments(): List<Document>

    suspend fun updateDocuments(existing:List<Document>): List<Document>

    data class Document(
        val documentType: DocumentEnums.DocumentType,
        val documentNumber: String? = null,
        val documentFormat: DocumentEnums.DocumentFormat? = null,
        val pages: List<DocumentPage>,
        val captureDate: Date,
        val captureMethod: DocumentEnums.CaptureMethod? = null
    ):DocumentEnums

    data class  DocumentPage(
        val pageCode: String? = null,
        val pageNumber: Int,
        val image: ByteArray
    )

}



