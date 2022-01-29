package com.etoolkit.domain.domain.repository

import com.etoolkit.domain.domain.models.SaveUserName
import com.etoolkit.domain.domain.models.UserName

interface UserRepository {

    fun saveName(saveUserName: SaveUserName) : Boolean

    fun getName() : UserName

}