package com.genkey.common.modules.registration.modules_registration_biographic_api

import com.genkey.common.modules.basic.Composable

interface Editor<T>
{
    @Composable
    suspend fun createNew(): T

    @Composable
    suspend fun update(type: T): T

    @Composable
    suspend fun showSummary(type: T)
}