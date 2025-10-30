package com.genkey.common.modules.face.module_face_verify_api

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.basic.ImageBytesHolder
import com.genkey.common.modules.face._module_face_common.FaceCommonAPI

interface  FaceVerificationAPI: FaceCommonAPI
{
    @Composable
    suspend fun verifyFace(imageToVerifyAgainst: ImageBytesHolder): Boolean
}