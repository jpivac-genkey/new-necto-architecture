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
interface IIdSignature: SignatureAPI.ISignature, IHavingID

open class Signature(override val id: UUID): IIdSignature
{
    data class GoodSignature(private val signature: Signature, override val image: ByteArray):
        IIdSignature by signature, SignatureAPI.ISignature.IGoodSignature
    {
        constructor(id: UUID, image: ByteArray): this(Signature(id), image)
        constructor(goodSignature: SignatureAPI.ISignature.IGoodSignature): this(UUID.UNASSIGNED, goodSignature.image)
    }

    data class ImpossibleToSign(private val signature: Signature, override val reason: String):
        IIdSignature by signature, SignatureAPI.ISignature.IImpossibleToSign
    {
        constructor(id: UUID, reason: String): this(Signature(id), reason)
        constructor(goodSignature: SignatureAPI.ISignature.IImpossibleToSign): this(UUID.UNASSIGNED, goodSignature.reason)
    }
}

