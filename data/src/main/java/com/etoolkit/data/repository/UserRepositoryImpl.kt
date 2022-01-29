package com.etoolkit.data.repository

import com.etoolkit.data.repository.storage.User
import com.etoolkit.data.repository.storage.UserStorage
import com.etoolkit.domain.domain.models.SaveUserName
import com.etoolkit.domain.domain.models.UserName
import com.etoolkit.domain.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveUserName: SaveUserName): Boolean {
        val user = User(firstName = saveUserName.name,lastName = " ")
        return userStorage.save(user)
    }

    override fun getName() : UserName {
        val user = userStorage.get()

        val userName = UserName(firstName = user.firstName,lastName = user.lastName)

        return userName
    }


}