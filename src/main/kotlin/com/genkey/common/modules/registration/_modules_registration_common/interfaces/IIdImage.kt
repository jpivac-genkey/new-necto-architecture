package com.genkey.common.modules.registration._modules_registration_common.interfaces

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_common.domain.Image


interface IIdImage: IImage, IHavingID

interface IImage
{
    val id: UUID
    val imageBytes: ByteArray
    val hash: String?
    val format: Image.Format
    val resolution: Int?
    val height: Int?
    val width: Int?
}