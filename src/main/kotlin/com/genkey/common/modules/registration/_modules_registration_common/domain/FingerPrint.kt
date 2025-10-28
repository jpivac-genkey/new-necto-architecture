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
class FingerPrint(
    val id: UUID,
    val idc: Int,
    val traumaType: TraumaType? = null,
    val traumaDetails: String? = null,
    val isTraumaPermanent: Boolean? = false,
    val isImpossibleToCapture: Boolean? = false,
    val impossibleToCaptureReason: String? = null,
    val image: Image? = null
)
{
    companion object
    {
        fun createForm(fp: FPCaptureAPI.FingerPrint): FingerPrint {
            return when (fp) {
                is FPCaptureAPI.FingerPrint.TraumaFingerPrint -> FingerPrint(
                    UUID.UNASSIGNED,
                    fp.idc, FingerPrint.TraumaType.createFrom(fp.traumaType),
                    fp.traumaDetails, fp.isTraumaPermanent
                )

                is FPCaptureAPI.FingerPrint.ImpossibleToCapture -> FingerPrint(
                    UUID.UNASSIGNED,
                    fp.idc, null, null,
                    null, true, fp.reason
                )

                is FPCaptureAPI.FingerPrint.GoodFingerPrint -> FingerPrint(
                    UUID.UNASSIGNED,
                    fp.idc, null, null,
                    null, null, null,
                    Image.createFrom(UUID.UNASSIGNED, fp.image)
                )
            }
        }
    }


    fun convert(): FPCaptureAPI.FingerPrint
    {
        isImpossibleToCapture?.let {
            return FPCaptureAPI.FingerPrint.ImpossibleToCapture(idc, impossibleToCaptureReason!!)
        }
        traumaType?.let {
            return FPCaptureAPI.FingerPrint.TraumaFingerPrint(idc, it.convert(), traumaDetails!!, isTraumaPermanent!!)
        }

        return FPCaptureAPI.FingerPrint.GoodFingerPrint(idc, image!!.imageBytes)
    }

    enum class TraumaType
    {
        ;
        companion object
        {
            fun createFrom(traumaType: FPCaptureAPI.FingerPrint.TraumaFingerPrint.TraumaType): TraumaType
            {
                TODO()
            }
        }

        fun convert() : FPCaptureAPI.FingerPrint.TraumaFingerPrint.TraumaType
        {
            TODO()
        }
    }




}