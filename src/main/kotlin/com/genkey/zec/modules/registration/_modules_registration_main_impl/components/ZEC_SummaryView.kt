package com.genkey.zec.modules.registration._modules_registration_main_impl.components

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.d_signature.module_signature_api.SignatureAPI
import com.genkey.common.modules.registration._modules_registration_main_impl.components.SummaryView
import com.genkey.zec.modules.d_signature.module_signature_api.ZEC_SignatureAPI
import com.genkey.zec.modules.registration._modules_registration_common.interfaces.IIdZEC_Subject

open class ZEC_SummaryView : SummaryView()
{
    @Composable
    override fun showSignature()
    {
        val subject: IIdZEC_Subject = TODO()

        //a new type has to be covered
        val signature: SignatureAPI.ISignature = subject.signature!!
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