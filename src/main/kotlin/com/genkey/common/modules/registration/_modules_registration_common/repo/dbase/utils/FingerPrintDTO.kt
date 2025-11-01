package com.genkey.common.modules.registration._modules_registration_common.repo.dbase.utils

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.fingerprints._module_fingerprints_common.FingerPrintsCommonAPI
import com.genkey.common.modules.registration._modules_registration_common.domain.FingerPrint
import com.genkey.common.modules.registration._modules_registration_common.domain.Image

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

/*
FingerPrint domain objects are more human-friendly and do not map directly to the dbase table row.
So we introduce this object that maps a row in the "fingerprints" table.

There are methods for conversions in both directions
  domain object --> DTO object
  DTO object domain --> object

Note that SubjectId is removed, since this class's belonging to a subject is expressed in another way.
 */
class FingerPrintDTO(
    val id: UUID? = null,
    val idc: Int,
    val traumaType: FingerPrintsCommonAPI.IFingerPrint.ITraumaFingerPrint.TraumaType? = null,
    val traumaDetails: String? = null,
    val isTraumaPermanent: Boolean? = false,
    val isImpossibleToCapture: Boolean? = false,
    val impossibleToCaptureReason: String? = null,
    val image: Image? = null
) {

    fun toFingerPrint(): FingerPrint
    {
        //the values with "!!" must be present
        isImpossibleToCapture?.let {
            return FingerPrint.ImpossibleToCapture(id, idc, impossibleToCaptureReason!!)
        }
        traumaType?.let {
            return FingerPrint.TraumaFingerPrint(id, idc, traumaType, traumaDetails!!, isTraumaPermanent!!)
        }

        return FingerPrint.GoodFingerPrint(id, idc, image!!)
    }
}


fun FingerPrint.toFingerPrintDTO() :FingerPrintDTO
{
    return when (this) {
        is FingerPrint.TraumaFingerPrint -> FingerPrintDTO(
            this.id, this.idc,
            this.traumaType,this.traumaDetails, this.isTraumaPermanent
        )

        is FingerPrint.ImpossibleToCapture -> FingerPrintDTO(
            this.id,
            this.idc,
            null, null,null,
            true, this.reason
        )

        is FingerPrint.GoodFingerPrint -> FingerPrintDTO(
            this.id,this.idc,
            null, null,null,
            null, null,
            Image(this.image)
        )

        else -> TODO("impossible to come here")
    }
}
