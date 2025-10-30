package com.genkey.common.modules.fingerprints._module_fingerprints_common

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
            val image: ByteArray
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

            enum class TraumaType
            {
                //
            }
        }
    }
}