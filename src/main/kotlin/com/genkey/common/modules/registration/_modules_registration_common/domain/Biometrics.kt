package com.genkey.common.modules.registration._modules_registration_common.domain


/**
 * No corresponding table in the dbase. This class is kind of aggregator of other tables.
 */
open class Biometrics (
    open val face: Face?,
    open val fingerPrints: FingerPrintSet?
    )

