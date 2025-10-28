package com.genkey.common.modules.registration._modules_registration_domain


/**
 * No corresponding table in the dbase. This class is kind of aggregator of other tables.
 */
open class Biometrics (
    val face: Face?,
    val fingerPrints: FingerPrints?,
    )
{

}
