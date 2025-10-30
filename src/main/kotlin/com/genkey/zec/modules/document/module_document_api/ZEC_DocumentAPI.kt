package com.genkey.zec.modules.document.module_document_api

import com.genkey.common.modules.document.module_document_api.DocumentAPI
import com.genkey.common.modules.document.module_document_api.DocumentAPI.*

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

    // new DocumentFormats
    enum class ZEC_DocumentFormatEnum(override val value: Int): DocumentFormat
    {
        //be careful that values do not overlap with the values of other DocumentFormat enum classes
        ZEC_DOC(6),
        ZEC_IMAGE(7),
        ZEC_OTHER(8)
    }

}