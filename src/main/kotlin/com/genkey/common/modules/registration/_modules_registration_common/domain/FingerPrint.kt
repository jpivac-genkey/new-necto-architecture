package com.genkey.common.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.d_signature.module_signature_api.SignatureAPI
import com.genkey.common.modules.fingerprints._module_fingerprints_common.FingerPrintsCommonAPI.IFingerPrint
import com.genkey.common.modules.fingerprints._module_fingerprints_common.FingerPrintsCommonAPI.IFingerPrint.ITraumaFingerPrint.TraumaType

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
abstract class FingerPrint private constructor (val id: UUID, override val idc: Int): IFingerPrint
{
    open class GoodFingerPrint(id: UUID,
                               idc:Int,
                               override val image: ByteArray):
        FingerPrint(id, idc), IFingerPrint.IGoodFingerPrint
    {
        //used for receiving the output from FingerPrint Capture  module
        constructor(fingerPrint:IFingerPrint.IGoodFingerPrint):
                this(UUID.UNASSIGNED, fingerPrint.idc, fingerPrint.image)
    }


    open class ImpossibleToCapture( id: UUID,
                                   idc: Int,
                                   override val reason: String):
        FingerPrint(id, idc), IFingerPrint.IImpossibleToCapture
    {
        //used for receiving the output from FingerPrint Capture  module
        constructor(fingerPrint:IFingerPrint.IImpossibleToCapture):
                this(UUID.UNASSIGNED, fingerPrint.idc, fingerPrint.reason)
    }



    open class TraumaFingerPrint(id: UUID,
                                 idc:Int,
                                 override val traumaType: TraumaType,
                                 override val traumaDetails: String,
                                 override val isTraumaPermanent: Boolean):
        FingerPrint(id, idc), IFingerPrint.ITraumaFingerPrint
    {
        //used for receiving the output from FingerPrint Capture  module
        constructor(fingerPrint:IFingerPrint.ITraumaFingerPrint):
                this(UUID.UNASSIGNED, fingerPrint.idc, fingerPrint.traumaType, fingerPrint.traumaDetails, fingerPrint.isTraumaPermanent)
    }



    //used for receiving the output from FingerPrint Capture  module
    interface FingerPrintCreator
    {
        operator fun invoke(fingerPrint:IFingerPrint): FingerPrint
    }

    companion object: FingerPrintCreator
    {
        //used for receiving the output from FingerPrint Capture  module
        override operator fun invoke(fingerPrint:IFingerPrint): FingerPrint
        {
            return when(fingerPrint)
            {
                is IFingerPrint.IGoodFingerPrint -> GoodFingerPrint(fingerPrint)
                is IFingerPrint.IImpossibleToCapture -> ImpossibleToCapture(fingerPrint)
                is IFingerPrint.ITraumaFingerPrint -> TraumaFingerPrint(fingerPrint)
                else -> TODO("Impossible to come here")
            }
        }
    }

}
