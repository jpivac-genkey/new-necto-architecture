package com.genkey.common.modules.registration.modules_registration_synch_api

import com.genkey.common.modules.basic.Composable

interface SynchronizationAPI
{
    @Composable
    suspend fun sendDataToSpire():Unit
}