package com.genkey.zec.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_common.domain.DocumentPage
import com.genkey.common.modules.registration._modules_registration_common.domain.IIdDocumentPage
import com.genkey.zec.modules.document.module_document_api.ZEC_DocumentAPI


data class ZEC_DocumentPage private constructor(
    private val docPage: DocumentPage,
    override val zecField1:Int
): IIdDocumentPage by docPage, ZEC_DocumentAPI.IZEC_DocumentPage
{
    constructor(id: UUID,
                pageCode: String? = null,
                pageNumber: Int,
                image: ByteArray,
                zecField1:Int):
            this(DocumentPage(id,pageCode, pageNumber, image ),zecField1 )
}