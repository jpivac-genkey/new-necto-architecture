package com.genkey.common.modules.registration.modules_registration_synch_api

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.basic.UUID
import com.genkey.common.modules.registration._modules_registration_domain.Subject

interface SynchronizationAPI
{
    @Composable
    suspend fun sendDataToSpire(subjectProvider: (UUID) -> Subject):Unit

}