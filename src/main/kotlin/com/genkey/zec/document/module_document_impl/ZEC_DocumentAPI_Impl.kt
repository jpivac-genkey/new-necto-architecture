package com.genkey.zec.document.module_document_impl

import com.genkey.common.modules.document.module_document_api.DocumentAPI.Document
import com.genkey.common.modules.document.module_document_impl.DocumentAPI_Impl

class ZEC_DocumentAPI_Impl : DocumentAPI_Impl()
{
    override suspend fun captureDocuments(): List<Document>
    {
        // a different logic for ZEC project, so this method is being overriden
        TODO()
    }
}