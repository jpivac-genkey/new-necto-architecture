package com.genkey.common.modules.fingerprints._module_fingerprints_common.domain

import com.genkey.common.modules.fingerprints._module_fingerprints_common.FingerPrintsCommonAPI.IFingerPrints

class Fingers(override val individualFingers: List<FingerPrint>) : IFingerPrints
{

}