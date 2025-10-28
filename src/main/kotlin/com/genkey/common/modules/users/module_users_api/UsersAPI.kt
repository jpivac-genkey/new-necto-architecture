package com.genkey.common.modules.users.module_users_api

import com.genkey.common.modules.basic.AppEventListener
import com.genkey.common.modules.basic.Composable

interface UsersAPI: AppEventListener
{
    @Composable
    suspend fun handleLogin(): UserRoles

    //if we want externally to initiate any work with Users (add, delete, edit, update)
    @Composable
    suspend fun doUsersManagement()

    fun getCurrentUser(): UserRoles

    /*
    When it comes to users this is enough for the rest of the application.
    Other modules just care what is the role of the current user on which they
    base what functionalities are available.
     */
    interface UserRoles
    {
        val loginName: String//maybe needed somewhere to show the name of the user

        val isAdministrator: Boolean
        val isSupervisor: Boolean
        val isSystem: Boolean
    }



    fun getTimeoutManager(): TimeoutManager

    interface TimeoutManager
    {
        fun registerListener(timeoutExpiredListener: TimeoutExpiredListener)
        fun unregisterListener(timeoutExpiredListener: TimeoutExpiredListener)

        interface TimeoutExpiredListener
        {
            fun onTimeoutExpired()
        }

        @Composable
        fun showTimeoutDialog(): Boolean //false = user chose to log out
    }

}

