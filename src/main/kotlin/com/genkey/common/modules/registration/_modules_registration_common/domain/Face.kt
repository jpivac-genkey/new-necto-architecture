package com.genkey.common.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.face.module_face_capture_api.FaceCaptureAPI

/**
 * CREATE TABLE public.face_profiles (
 * 	id uuid NOT NULL,
 * 	image_id uuid NOT NULL,
 * 	thumbnail_image_id uuid NULL,
 * 	is_forced_capture bool DEFAULT false NOT NULL,
 * 	subject_id uuid NOT NULL,
 * 	spire_transaction_id uuid NOT NULL,
 * 	CONSTRAINT pk_face_profiles PRIMARY KEY (id),
 * 	CONSTRAINT fk_face_profiles_images FOREIGN KEY (image_id) REFERENCES public.images(id),
 * 	CONSTRAINT fk_face_profiles_images_thumbnail FOREIGN KEY (thumbnail_image_id) REFERENCES public.images(id),
 * 	CONSTRAINT fk_face_profiles_spire_transactions FOREIGN KEY (spire_transaction_id) REFERENCES public.spire_transactions(id),
 * 	CONSTRAINT fk_face_profiles_subjects FOREIGN KEY (subject_id) REFERENCES public.subjects(id)
 * );
 */
/**
 * SubjectId is removed, since this class's belonging to a subject is expressed in another way.
 * "id" is here just for update when this object is to be written to the exactly same row in the dbase
 * In case of creation of a new object, the id is assigned a 'UUID.UNASSIGNED' value, since that object
 * has never been in the dbase.
 */
open class Face(
    val id: UUID,
    val image:Image,
    val thumbnailImage: Image?,
    val isForcedCapture: Boolean? = false
)
{
    companion object
    {
        fun createFrom(_face: FaceCaptureAPI.Face): Face
        {
            val image = Image.createFrom(UUID.UNASSIGNED, _face.image)
            val thumbnailImage = _face.thumbnailImage?.let { Image.createFrom(UUID.UNASSIGNED, it) }
            return Face(UUID.UNASSIGNED, image, thumbnailImage, _face.isForcedCapture )
        }
    }

    fun convert(): FaceCaptureAPI.Face
    {
        return FaceCaptureAPI.Face(image.imageBytes, thumbnailImage?.imageBytes, isForcedCapture)
    }
}