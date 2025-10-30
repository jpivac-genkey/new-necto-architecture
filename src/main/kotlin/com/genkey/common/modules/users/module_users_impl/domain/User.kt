package com.genkey.common.modules.users.module_users_impl.domain


import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.basic.ValInterface
import com.genkey.common.modules.users.module_users_api.UsersAPI
import java.util.*

data class User(
    var id: UUID,

    override val loginName:String = "",
    var name: String = "",

    //creation
    val created: Date,
    val createdBy: String,

    //current status
    val securityStatus: SecurityStatus,

    //roles
    override val isAdministrator: Boolean = false,
    override val isSupervisor: Boolean = false,
    override val isSystem: Boolean = false,
    var isSystemUser: Boolean = false,  //??????

    //password related
    val password: String? = null,
    val isFirstTimeLoggingIn: Boolean = false,
    val hint1:String?= null,
    val hint2:String?= null,
    val hint3:String?= null,
    val lastPasswordChangedDate: Date? = null,

    //face verification
    val facialImage: ByteArray?= null,

    //fingerprints verification
    val bioHash: ByteArray?= null

    ) : UsersAPI.UserRoles
{

    interface SecurityStatus: ValInterface

    enum class SecurityStatusEnum(override val value: Int): SecurityStatus
    {
        NEW(1),
        ACTIVE(2),
        DISABLED(3),
        REMOVED(4)
    }
}