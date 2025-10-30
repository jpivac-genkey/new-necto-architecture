package com.genkey.common.modules.face.module_face_capture_api

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.basic.ImageBytesHolder
import com.genkey.common.modules.face._module_face_common.FaceCommonAPI

interface  FaceCaptureAPI: FaceCommonAPI
{
    @Composable
    suspend fun captureFace():  IFace //image returned

    @Composable
    suspend fun updateFace(existingFace:  IFace ):IFace //image returned

    interface IFace {
        val image: ImageBytesHolder
        val thumbnailImage: ImageBytesHolder?
        val isForcedCapture: Boolean?
    }
}