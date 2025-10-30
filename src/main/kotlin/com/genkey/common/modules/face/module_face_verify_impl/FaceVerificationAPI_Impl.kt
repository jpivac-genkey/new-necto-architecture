package com.genkey.common.modules.face.module_face_verify_impl

import com.genkey.common.modules.basic.AbstractModuleComp
import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.basic.ImageBytesHolder
import com.genkey.common.modules.face.module_face_verify_api.FaceVerificationAPI

class FaceVerificationAPI_Impl : AbstractModuleComp(), FaceVerificationAPI
{
    @Composable
    override suspend fun verifyFace(imageToVerifyAgainst: ImageBytesHolder): Boolean
    {
        return true
    }
}