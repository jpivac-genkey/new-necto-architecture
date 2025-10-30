package com.genkey.zec.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.ImageBytesHolder
import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_common.domain.DocumentPage
import com.genkey.common.modules.registration._modules_registration_common.domain.Image
import com.genkey.zec.modules.document.module_document_api.ZEC_DocumentAPI

class ZEC_DocumentPage(id: UUID,
                       pageCode: String? = null,
                       pageNumber: Int,
                       image: Image,
                       override val zecField1:Int):
    DocumentPage(id,pageCode, pageNumber, image ), ZEC_DocumentAPI.IZEC_DocumentPage
{
    //used for receiving the output from Document module
    constructor(id: UUID, zec_documentPage: ZEC_DocumentAPI.IZEC_DocumentPage):
            this(id,
                zec_documentPage.pageCode,
                zec_documentPage.pageNumber,
                Image(zec_documentPage.image),
                zec_documentPage.zecField1 )
}