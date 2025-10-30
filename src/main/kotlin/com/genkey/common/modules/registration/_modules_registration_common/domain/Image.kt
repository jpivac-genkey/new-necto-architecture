package com.genkey.common.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.UUID

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
    val id: UUID = UUID.UNASSIGNED,
    val imageBytes: ByteArray,
    val hash: String? = null,
    val format: Format,
    val resolution: Int? = null,
    val height: Int? = null,
    val width: Int? = null
)
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
