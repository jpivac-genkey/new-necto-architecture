package com.genkey.zec.document

import com.genkey.common.modules.document.module_document_impl.ConfigProvider

/**
 * A new 'documentMaxSize' parameter in the config file is introduced
 */
class ZEC_ConfigProvider : ConfigProvider()
{
    override fun getConfiguration(): Configuration
    {
        val configuration = super.getConfiguration()

        return ZEC_Configuration (
            scanOnlyPDF = configuration.scanOnlyPDF,
            documentsRequired = configuration.documentsRequired,
            atleastOneDocumentRequired = configuration.atleastOneDocumentRequired,

            documentMaxSize = configManager.getInt("documentMaxSize" , 150000),
        )
    }

    class ZEC_Configuration(
        scanOnlyPDF:Boolean,
        documentsRequired:String,
        atleastOneDocumentRequired:String,
        val documentMaxSize:Int, // <--------------- a new value read from configuration
        ): Configuration(scanOnlyPDF, documentsRequired, atleastOneDocumentRequired)

}