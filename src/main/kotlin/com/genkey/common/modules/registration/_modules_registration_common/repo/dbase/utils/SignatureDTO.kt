package com.genkey.common.modules.registration._modules_registration_common.repo.dbase.utils

import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_common.domain.Image
import com.genkey.common.modules.registration._modules_registration_common.domain.Signature
import com.genkey.common.modules.registration._modules_registration_common.domain.Signature.GoodSignature
import com.genkey.common.modules.registration._modules_registration_common.domain.Signature.ImpossibleToSign

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
)*/

/*
Signature domain objects are more human-friendly and do not map directly to the dbase table row.
So we introduce this object that maps a row in the "signatures_profiles" table.

There are methods for conversions in both directions
  domain object --> DTO object
  DTO object domain --> object

Note that SubjectId is removed, since this class's belonging to a subject is expressed in another way.
 */
class SignatureDTO(
    val id: UUID ?=null,
    val isImpossibleToSign: Boolean? = false,
    val impossibleToSignReason: String? = null,
    val image: Image?)
{
    fun toSignature():Signature
    {
        if(isImpossibleToSign == false)
        {
            //the image must be present
            return GoodSignature(id, this.image!!)
        }
        else
        {
            //the 'impossibleToSignReason' must be present
            return ImpossibleToSign(id, this.impossibleToSignReason!!)
        }
    }
}


fun Signature.toSignatureDTO() :SignatureDTO
{
    return when(this)
    {
        is Signature.GoodSignature -> SignatureDTO(this.id, false, null, this.image)
        is Signature.ImpossibleToSign -> SignatureDTO(this.id, true, this.reason, null)
        else -> TODO("Impossible to come here")
    }
}


