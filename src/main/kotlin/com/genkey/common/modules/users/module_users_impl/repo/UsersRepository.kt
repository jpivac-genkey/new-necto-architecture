package com.genkey.common.modules.users.module_users_impl.repo

import com.genkey.common.modules.basic.RepoResultState
import com.genkey.common.modules.users.module_users_impl.domain.User

interface UsersRepository
{
    fun getAllUsers(): RepoResultState<List<User>>
    fun saveUser(user: User): RepoResultState<Unit>
}