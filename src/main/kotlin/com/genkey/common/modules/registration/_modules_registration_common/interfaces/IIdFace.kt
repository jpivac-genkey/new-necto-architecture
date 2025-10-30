package com.genkey.common.modules.registration._modules_registration_common.interfaces

import com.genkey.common.modules.registration._modules_registration_common.domain.Image

interface IIdFace: IFace, IHavingID

interface IFace
{
    val image: Image
    val thumbnailImage: Image?
    val isForcedCapture: Boolean?
}