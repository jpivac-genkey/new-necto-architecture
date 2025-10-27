package com.genkey.common.modules.users.module_users_impl.repo.impl

import com.genkey.common.modules.basic.RepoResultState
import com.genkey.common.modules.users.module_users_impl.domain.User
import com.genkey.common.modules.users.module_users_impl.repo.UsersRepository

class UserRepositoryImpl: UsersRepository
{
    override fun getAllUsers(): RepoResultState<List<User>> {
        TODO("Not yet implemented")
    }

    override fun saveUser(user: User): RepoResultState<Unit> {
        TODO("Not yet implemented")
    }

}