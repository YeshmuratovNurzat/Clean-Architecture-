package com.etoolkit.data.repository.storage

interface UserStorage {

    fun save(user: User) : Boolean

    fun get() : User

}