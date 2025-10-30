package com.genkey.common.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IIdImage
import com.genkey.common.modules.registration._modules_registration_common.interfaces.IImage

/*
CREATE TABLE public.images (
	id uuid NOT NULL,
	image bytea NOT NULL,
	hash varchar(128) NULL,
	format varchar(4) NOT NULL,
	resolution int4 NULL,
	height int4 NULL,
	width int4 NULL,
	CONSTRAINT pk_images PRIMARY KEY (id)
);

 */
class Image(
    override val id: UUID = UUID.UNASSIGNED,
    override val imageBytes: ByteArray,
    override val hash: String? = null,
    override val format: Format,
    override val resolution: Int? = null,
    override val height: Int? = null,
    override val width: Int? = null
): IIdImage
{
    companion object
    {
        fun createFrom(id: UUID = UUID.UNASSIGNED, imageBytes: ByteArray):Image
        {
            //Fill the other fields
            //"imageBytes" in its header have info on format, resolution, height,...
            TODO()
        }
    }

    enum class Format{

    }


}
