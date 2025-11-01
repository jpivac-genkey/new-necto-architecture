package com.genkey.common.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.document.module_document_api.DocumentAPI
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
 * In case of creation of a new object, the id is assigned null value, since that object
 * has never been in the dbase.
 */
open class Face(
    val id: UUID? = null,
    override val image:Image,
    override val thumbnailImage: Image?,
    override val isForcedCapture: Boolean? = false
):FaceCaptureAPI.IFace
{
    //used for receiving the output from Document module
    constructor(_face: FaceCaptureAPI.IFace): this(
        null,
        Image(_face.image),
        _face.thumbnailImage?.let{Image(it)},
        _face.isForcedCapture)
}