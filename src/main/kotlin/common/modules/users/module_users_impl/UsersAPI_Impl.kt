package com.genkey.common.modules.users.module_users_impl

import com.genkey.common.modules.basic.AbstractModuleComp
import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.face.module_face_capture_api.FaceCaptureAPI
import com.genkey.common.modules.face.module_face_capture_impl.FaceCaptureAPI_Impl
import com.genkey.common.modules.face.module_face_verify_api.FaceVerificationAPI
import com.genkey.common.modules.face.module_face_verify_impl.FaceVerificationAPI_Impl
import com.genkey.common.modules.fingerprints.module_fingerprints_capture_api.FPCaptureAPI
import com.genkey.common.modules.fingerprints.module_fingerprints_capture_impl.FPCaptureAPI_Impl
import com.genkey.common.modules.fingerprints.module_fingerprints_verify_api.FPVerificationAPI
import com.genkey.common.modules.fingerprints.module_fingerprints_verify_impl.FPVerificationAPI_Impl
import com.genkey.common.modules.users.module_users_api.UsersAPI
import com.genkey.common.modules.users.module_users_impl.repo.impl.UserRepositoryImpl

class UsersAPI_Impl: AbstractModuleComp(), UsersAPI
{
    private val userRepository = UserRepositoryImpl()

    //To be used if login is based on face verification
    private val faceCaptureAPI : FaceCaptureAPI = FaceCaptureAPI_Impl() //inserted by DI, singleton
    private val faceVerificationAPI : FaceVerificationAPI = FaceVerificationAPI_Impl() //inserted by DI, singleton

    //To be used if login is based on fingerprints verification
    private val fpCaptureAPI : FPCaptureAPI = FPCaptureAPI_Impl() //inserted by DI, singleton
    private val fpVerificationAPI : FPVerificationAPI = FPVerificationAPI_Impl() //inserted by DI, singleton

    @Composable
    override suspend fun handleLogin(): UsersAPI.UserRoles
    {
        TODO("Not yet implemented")
    }

    @Composable
    override suspend fun doUsersManagement()
    {
        TODO("Not yet implemented")
    }

    override fun getTimeoutManager(): UsersAPI.TimeoutManager
    {
        TODO("Not yet implemented")
    }

    override fun getCurrentUser(): UsersAPI.UserRoles
    {
        TODO("Not yet implemented")
    }

}