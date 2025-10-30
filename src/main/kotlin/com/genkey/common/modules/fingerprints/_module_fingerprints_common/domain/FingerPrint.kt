package com.genkey.common.modules.fingerprints._module_fingerprints_common.domain


import com.genkey.common.modules.basic.ImageBytesHolder
import com.genkey.common.modules.fingerprints._module_fingerprints_common.FingerPrintsCommonAPI.IFingerPrint
import com.genkey.common.modules.fingerprints._module_fingerprints_common.FingerPrintsCommonAPI.IFingerPrint.ITraumaFingerPrint.TraumaType

abstract class FingerPrint private constructor(override val idc: Int):IFingerPrint
{
    open class GoodFingerPrint(idc:Int,
                               override val image: ImageBytesHolder
    ) : FingerPrint(idc), IFingerPrint.IGoodFingerPrint

    open class ImpossibleToCapture(idc:Int,
                               override val reason: String) : FingerPrint(idc), IFingerPrint.IImpossibleToCapture

    open class TraumaFingerPrint(idc:Int,
                                override val traumaType: TraumaType,
                                override val traumaDetails: String,
                                override val isTraumaPermanent: Boolean) : FingerPrint(idc),IFingerPrint.ITraumaFingerPrint

}