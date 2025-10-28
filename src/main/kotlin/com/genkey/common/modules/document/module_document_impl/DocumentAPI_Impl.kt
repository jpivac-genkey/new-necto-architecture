package com.genkey.common.modules.document.module_document_impl

import com.genkey.common.modules.document.module_document_api.DocumentAPI
import com.genkey.common.modules.registration._modules_registration_domain.Document


open class DocumentAPI_Impl: DocumentAPI
{
    override suspend fun captureDocuments(): List<Document>
    {
        TODO("Not yet implemented")
    }

    override suspend fun updateDocuments(existing:List<Document>): List<Document>
    {
        TODO("Not yet implemented")
    }
}



