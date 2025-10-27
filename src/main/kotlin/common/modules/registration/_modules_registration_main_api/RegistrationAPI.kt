package com.genkey.common.modules.registration._modules_registration_main_api

import com.genkey.common.modules.basic.AppEventListener
import com.genkey.common.modules.basic.Composable

interface RegistrationAPI: AppEventListener  
{
    @Composable
    suspend fun addNewSubject()
    
    @Composable
    suspend fun updateSubject()
    
    @Composable
    suspend fun doComingHome()
}