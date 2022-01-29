package com.etoolkit.domain.domain.usecase

import com.etoolkit.domain.domain.models.SaveUserName
import com.etoolkit.domain.domain.repository.UserRepository

class SaveNameUseCase(private val userRepository: UserRepository) {

    fun execute(name : SaveUserName) : Boolean {
        val result : Boolean = userRepository.saveName(saveUserName = name)
        return result
    }
}