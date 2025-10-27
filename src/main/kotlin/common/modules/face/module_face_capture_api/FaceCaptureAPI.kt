package com.genkey.common.modules.face.module_face_capture_api

import com.genkey.common.modules.basic.Composable

interface  FaceCaptureAPI
{
    @Composable
    suspend fun captureNewFace():  Face //image returned

    @Composable
    suspend fun updateFace(existingFace:  Face ):Face //image returned

    class Face(
        val image: ByteArray,
        val thumbnailImage: ByteArray?,
        val isForcedCapture: Boolean? = false
    )
}