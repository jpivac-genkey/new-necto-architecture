package com.genkey.common.modules.face.module_face_verify_api

import com.genkey.common.modules.basic.Composable

interface  FaceVerificationAPI
{
    @Composable
    suspend fun verifyFace(imageToVerifyAgainst: ByteArray): Boolean
}