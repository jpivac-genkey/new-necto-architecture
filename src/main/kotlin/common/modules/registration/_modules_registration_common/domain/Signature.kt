package com.genkey.common.modules.registration._modules_registration_common.domain

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.d_signature.module_signature_api.SignatureAPI

/*
CREATE TABLE public.signatures_profiles (
	id uuid NOT NULL,
	is_impossible_to_sign bool DEFAULT false NULL,
	impossible_to_sing_reason varchar(128) NULL,
	image_id uuid NULL,
	subject_id uuid NOT NULL,
	spire_transaction_id uuid NOT NULL,
	CONSTRAINT pk_signature_profiles PRIMARY KEY (id),
	CONSTRAINT fk_signature_profiles_images FOREIGN KEY (image_id) REFERENCES public.images(id),
	CONSTRAINT fk_signature_profiles_spire_transactions FOREIGN KEY (spire_transaction_id) REFERENCES public.spire_transactions(id),
	CONSTRAINT fk_signature_profiles_subjects FOREIGN KEY (subject_id) REFERENCES public.subjects(id)
);
 */
/**
 * SubjectId is removed, since this class's belonging to a subject is expressed in another way.
 * "id" is here just for update when this object is to be written to the exactly same row in the dbase
 * In case of creation of a new object, the id is assigned a 'UUID.UNASSIGNED' value, since that object
 * has never been in the dbase.
 */
class Signature(
    val id: UUID,
    val isImpossibleToSign: Boolean? = false,
    val impossibleToSignReason: String? = null,
    val image: Image?
)
{
    companion object
    {
        fun createFrom(_signature: SignatureAPI.Signature): Signature
        {
            if(_signature is SignatureAPI.Signature.GoodSignature)
            {
                val image = Image.createFrom(UUID.UNASSIGNED, _signature.image)
                return Signature(UUID.UNASSIGNED, false,null, image)
            }
            else
            {
                val reason = (_signature as SignatureAPI.Signature.ImpossibleToSign).reason
                return Signature(UUID.UNASSIGNED, true, reason, null)
            }
        }
    }


    fun convert(): SignatureAPI.Signature
    {
        if(isImpossibleToSign == false)
        {
            return SignatureAPI.Signature.GoodSignature(this.image!!.imageBytes)
        }
        else
        {
            return SignatureAPI.Signature.ImpossibleToSign(this.impossibleToSignReason!!)
        }
    }

}
