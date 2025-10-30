package com.genkey.zec.modules.document.module_document_api

import com.genkey.common.modules.document.module_document_api.DocumentAPI
import com.genkey.common.modules.document.module_document_api.DocumentAPI.IDocument
import com.genkey.common.modules.document.module_document_api.DocumentAPI.IDocumentPage

interface ZEC_DocumentAPI : DocumentAPI {

    interface IZEC_Document: IDocument
    {
        val zecField2:Int
        override val pages: List<IZEC_DocumentPage>
    }

    interface IZEC_DocumentPage: IDocumentPage
    {
        val zecField1:Int
    }
}