package com.genkey.zec.modules.registration._modules_registration_main_impl.components

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.registration._modules_registration_common.domain.Document
import com.genkey.common.modules.registration._modules_registration_common.domain.Signature
import com.genkey.common.modules.registration._modules_registration_main_impl.components.SummaryView
import com.genkey.zec.modules.registration._modules_registration_common.domain.ZEC_Signature
import com.genkey.zec.modules.registration._modules_registration_common.domain.ZEC_Subject

open class ZEC_SummaryView : SummaryView()
{
    @Composable
    override fun showSignature(signature: Signature)
    {
        when(signature)
        {
            is ZEC_Signature.GoodSignatureCopiedFromSource -> {
                signature.sourceImage //show source image
                signature.image //show signature
            }

            is Signature.GoodSignature -> {
                signature.image //show image
            }

            is Signature.ImpossibleToSign ->  {
                signature.reason //show reason
            }
        }
    }

    override fun showDocuments(documents: List<Document>)
    {

    }

}