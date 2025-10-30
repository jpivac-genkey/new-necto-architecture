package com.genkey.common.modules.fingerprints._module_fingerprints_common

import com.genkey.common.modules.basic.ImageBytesHolder
import com.genkey.common.modules.basic.ValInterface

interface FingerPrintsCommonAPI
{
    interface  IFingerPrints
    {
        val individualFingers: List<IFingerPrint>
    }

    interface  IFingerPrint
    {
        val idc: Int

        interface  IGoodFingerPrint: IFingerPrint
        {
            val image: ImageBytesHolder
        }

        interface  IImpossibleToCapture: IFingerPrint
        {
            val reason: String
        }

        interface ITraumaFingerPrint: IFingerPrint
        {
            val traumaType: TraumaType
            val traumaDetails: String
            val isTraumaPermanent: Boolean

            interface TraumaType:ValInterface

            enum class TraumaTypeEnum(override val value: Int): TraumaType
            {
                //
            }
        }
    }
}