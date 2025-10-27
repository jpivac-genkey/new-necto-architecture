package com.genkey.common.modules.face.module_face_capture_impl

import com.genkey.common.modules.basic.AbstractModuleComp
import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.face.module_face_capture_api.FaceCaptureAPI

class FaceCaptureAPI_Impl : AbstractModuleComp(), FaceCaptureAPI
{
    @Composable
    override suspend fun captureNewFace():  FaceCaptureAPI.Face
    {
        TODO()
    }

    @Composable
    override suspend fun updateFace(existingFace: FaceCaptureAPI.Face ): FaceCaptureAPI.Face
    {
        TODO()
    }
}