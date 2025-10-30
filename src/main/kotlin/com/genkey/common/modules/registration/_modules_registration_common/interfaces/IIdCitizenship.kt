package com.genkey.common.modules.registration._modules_registration_common.interfaces

interface IIdCitizenship: ICitizenship, IHavingID

interface ICitizenship
{
    val documentType: DocumentType
    val documentId: String
    val countryCode: CountryCode
    val nationality: Nationality?
    val isByBirth: Boolean

    enum class DocumentType{
        //do we already have the values somewhere in the code?
    }

    /*
    For "nationality" and "countryCode" we can use just strings.
    Or to go with enums where we predefine all possible values.
     */
    enum class Nationality{

    }
    enum class CountryCode{
        //we can find the list of international official codes for all countries
    }
}