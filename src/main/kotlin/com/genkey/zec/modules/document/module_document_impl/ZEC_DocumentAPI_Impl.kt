package com.genkey.zec.modules.document.module_document_impl

import com.genkey.common.modules.document.module_document_api.DocumentAPI.*
import com.genkey.common.modules.document.module_document_impl.DocumentAPI_Impl
import com.genkey.zec.modules.document.module_document_api.ZEC_DocumentAPI
import com.genkey.zec.modules.document.module_document_impl.domain.ZEC_Document
import com.genkey.zec.modules.document.module_document_impl.domain.ZEC_DocumentPage
import java.util.*

class ZEC_DocumentAPI_Impl : DocumentAPI_Impl(),ZEC_DocumentAPI
{
    override suspend fun captureDocuments(): List<ZEC_DocumentAPI.IZEC_Document>
    {
        // a different logic for ZEC project, so this method is being overriden
        val zecDocumentpage = ZEC_DocumentPage(
            null,
            1,
            ByteArray(0),
            zecField1 = 12345)

        val zecDocument = ZEC_Document(DocumentType.REGISTRATION_DOCUMENTS,
            "1234",
            DocumentFormat.DOC,
            mutableListOf(zecDocumentpage),
            Date(),
            CaptureMethod.CAPTURE,
            zecField2 = 1213245)

        return listOf(zecDocument)
    }

    override suspend fun updateDocuments(existing: List<IDocument>): List<ZEC_DocumentAPI.IZEC_Document>
    {
        TODO()
    }

}