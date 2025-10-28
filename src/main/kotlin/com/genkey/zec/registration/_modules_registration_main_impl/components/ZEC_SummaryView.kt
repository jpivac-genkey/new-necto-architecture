package com.genkey.zec.registration._modules_registration_main_impl.components

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.registration._modules_registration_common.domain.Contact
import com.genkey.common.modules.registration._modules_registration_main_impl.components.SummaryView
import com.genkey.zec.d_signature.module_signature_api.ZEC_SignatureAPI
import com.genkey.zec.registration._modules_registration_common.domain.ZEC_Contact

open class ZEC_SummaryView : SummaryView()
{
    @Composable
    override fun showSignature()
    {
        //a new type has to be covered
        //ZEC_SignatureAPI.ZEC_Signature.GoodSignatureCopiedFromSource
        TODO()
    }

}