package com.genkey.common.modules.document.module_document_impl

import com.genkey.common.modules.document.module_document_api.DocumentAPI
import com.genkey.common.modules.document.module_document_api.DocumentAPI.IDocument

open class DocumentAPI_Impl: DocumentAPI
{
    override suspend fun captureDocuments(): List<IDocument>
    {
        TODO("Not yet implemented")
    }

    override suspend fun updateDocuments(existing:List<IDocument>): List<IDocument>
    {
        TODO("Not yet implemented")
    }
}



