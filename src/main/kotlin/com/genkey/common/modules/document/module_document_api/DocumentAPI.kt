package com.genkey.common.modules.document.module_document_api

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.registration._modules_registration_domain.Document


interface  DocumentAPI
{
    @Composable
    suspend fun captureDocuments(): List<Document>

    suspend fun updateDocuments(existing:List<Document>): List<Document>

}



