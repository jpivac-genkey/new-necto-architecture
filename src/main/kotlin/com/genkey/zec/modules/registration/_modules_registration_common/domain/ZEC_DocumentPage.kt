package com.genkey.zec.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_common.domain.DocumentPage
import com.genkey.common.modules.registration._modules_registration_common.domain.IIdDocumentPage
import com.genkey.zec.modules.document.module_document_api.ZEC_DocumentAPI
import com.genkey.zec.modules.registration._modules_registration_common.interfaces.IIdZEC_DocumentPage

data class ZEC_DocumentPage private constructor(
    private val docPage: DocumentPage,
    override val zecField1:Int
): IIdDocumentPage by docPage, IIdZEC_DocumentPage
{
    //used by Repository with the data read from the dbase
    constructor(id: UUID,
                pageCode: String? = null,
                pageNumber: Int,
                image: ByteArray,
                zecField1:Int):
            this(DocumentPage(id,pageCode, pageNumber, image ),zecField1 )

    //used for receiving the output from Document module
    constructor(id: UUID, zec_documentPage: ZEC_DocumentAPI.IZEC_DocumentPage):
            this(id,
                zec_documentPage.pageCode,
                zec_documentPage.pageNumber,
                zec_documentPage.image,
                zec_documentPage.zecField1 )
}