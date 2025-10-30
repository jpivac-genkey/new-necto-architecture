package com.genkey.zec.modules.registration._modules_registration_common.interfaces

import com.genkey.common.modules.registration._modules_registration_common.domain.IIdDocument
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IHavingID
import com.genkey.zec.modules.document.module_document_api.ZEC_DocumentAPI
import com.genkey.zec.modules.document.module_document_api.ZEC_DocumentAPI.IZEC_DocumentPage

interface IIdZEC_Document: ZEC_DocumentAPI.IZEC_Document, IIdDocument
{
    override val pages: List<IZEC_DocumentPage>
}