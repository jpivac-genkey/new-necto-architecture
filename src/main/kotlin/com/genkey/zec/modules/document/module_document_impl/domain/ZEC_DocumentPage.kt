package com.genkey.zec.modules.document.module_document_impl.domain

import com.genkey.common.modules.basic.ImageBytesHolder
import com.genkey.common.modules.document.module_document_impl.domain.DocumentPage
import com.genkey.zec.modules.document.module_document_api.ZEC_DocumentAPI


class ZEC_DocumentPage (
    pageCode: String? = null,
    pageNumber: Int,
    image: ImageBytesHolder,
    override val zecField1:Int
): DocumentPage(pageCode, pageNumber, image), ZEC_DocumentAPI.IZEC_DocumentPage
