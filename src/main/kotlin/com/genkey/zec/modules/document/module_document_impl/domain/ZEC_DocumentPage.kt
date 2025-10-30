package com.genkey.zec.modules.document.module_document_impl.domain

import com.genkey.common.modules.basic.ImageBytesHolder
import com.genkey.common.modules.document.module_document_api.DocumentAPI
import com.genkey.common.modules.document.module_document_impl.domain.DocumentPage
import com.genkey.zec.modules.document.module_document_api.ZEC_DocumentAPI


data class ZEC_DocumentPage private constructor(
    private val docPage: DocumentPage,
    override val zecField1:Int
): DocumentAPI.IDocumentPage by docPage, ZEC_DocumentAPI.IZEC_DocumentPage
{
    //the only constructor to be used
    constructor(pageCode: String? = null,
                pageNumber: Int,
                image: ImageBytesHolder,
                zecField1:Int):
            this(DocumentPage(pageCode, pageNumber, image ),zecField1 )
}
