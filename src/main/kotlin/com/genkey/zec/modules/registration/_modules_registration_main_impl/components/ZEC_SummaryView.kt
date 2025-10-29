package com.genkey.zec.modules.registration._modules_registration_main_impl.components

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.d_signature.module_signature_api.SignatureAPI
import com.genkey.common.modules.registration._modules_registration_main_impl.components.SummaryView
import com.genkey.zec.modules.d_signature.module_signature_api.ZEC_SignatureAPI

open class ZEC_SummaryView : SummaryView()
{
    @Composable
    override fun showSignature()
    {
        //a new type has to be covered
        val signature: SignatureAPI.ISignature = TODO()
        when(signature)
        {
            is ZEC_SignatureAPI.IZEC_Signature.IGoodSignatureCopiedFromSource -> {
                signature.sourceImage //show source image
                signature.image //show signature
            }

            is SignatureAPI.ISignature.IGoodSignature -> {
                signature.image //show image
            }

            is SignatureAPI.ISignature.IImpossibleToSign ->  {
                signature.reason //show reason
            }
        }
    }

}