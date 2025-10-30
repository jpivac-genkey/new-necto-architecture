package com.genkey.common.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IBiographics
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IBiometrics
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IIdSubject
import java.util.*

/**
 *
 * It has the corresponding table in the dbase, but mainly this class aggregates other tables.
 * The values from that table are  the 'id', 'registrationDate' and the rest in the 'biographics'.
 *
 * "id" is here just for update when this object is to be written to the exactly same row in the dbase
 * In case of creation of a new object, the id is assigned a 'UUID.UNASSIGNED' value, since that object
 * has never been in the dbase.
 */


open class Subject(
    override val id: UUID,
    override val registrationDate: Date,
    override val biographics: IBiographics,
    override val biometrics: IBiometrics? = null,
    override val signature: IIdSignature? = null,
    override val documents: List<IIdDocument>? = null
): IIdSubject
