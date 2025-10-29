package com.genkey.common.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.fingerprints.module_fingerprints_capture_api.FPCaptureAPI

/*
CREATE TABLE public.fingerprints (
	id uuid NOT NULL,
	idc int4 NOT NULL,
	trauma_type varchar(32) NULL,
	trauma_details varchar(128) NULL,
	is_trauma_permanent bool DEFAULT false NULL,
	is_impossible_to_capture bool DEFAULT false NULL,
	impossible_to_capture_reason varchar(128) NULL,
	image_id uuid NULL,
	fingerprints_profile_id uuid NOT NULL,
	CONSTRAINT pk_fingerprints PRIMARY KEY (id),
	CONSTRAINT fk_fingerprints FOREIGN KEY (image_id) REFERENCES public.images(id),
	CONSTRAINT fk_fingerprints_fingerprints_profiles FOREIGN KEY (fingerprints_profile_id) REFERENCES public.fingerprints_profiles(id)
);
 */
/**
 * "fingerprints_profile_id" is removed, since this class's belonging to a subject is expressed in another way.
 * "id" is here just for update when this object is to be written to the exactly same row in the dbase
 * In case of creation of a new object, the id is assigned a 'UUID.UNASSIGNED' value, since that object
 * has never been in the dbase.
 */
open class FingerPrint
{
    open class GoodFingerPrint(val id: UUID, idc:Int, image: ByteArray) : FPCaptureAPI.FingerPrint.GoodFingerPrint(idc, image)

    open class ImpossibleToCapture(val id: UUID, idc:Int, reason: String) : FPCaptureAPI.FingerPrint.ImpossibleToCapture(idc, reason)

    open class TraumaFingerPrint(val id: UUID, idc:Int, traumaType: TraumaType,
                                 traumaDetails: String, isTraumaPermanent: Boolean):
        FPCaptureAPI.FingerPrint.TraumaFingerPrint(idc, traumaType, traumaDetails, isTraumaPermanent)
}
