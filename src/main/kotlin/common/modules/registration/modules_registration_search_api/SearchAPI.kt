package com.genkey.common.modules.registration.modules_registration_search_api

import com.genkey.common.modules.basic.Composable
import com.genkey.common.modules.basic.UUID

interface SearchAPI {

    @Composable
    suspend fun performSearch(): UUID? //selected subject ID

}