package com.genkey.common.modules.document.module_document_impl.domain

import com.genkey.common.modules.document.module_document_api.DocumentAPI

data class DocumentPage(
    override val pageCode: String? = null,
    override val pageNumber: Int,
    override val image: ByteArray): DocumentAPI.IDocumentPage
