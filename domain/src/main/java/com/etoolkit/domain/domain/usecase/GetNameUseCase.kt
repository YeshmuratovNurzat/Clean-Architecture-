package com.etoolkit.domain.domain.usecase

import com.etoolkit.domain.domain.models.UserName
import com.etoolkit.domain.domain.repository.UserRepository

class GetNameUseCase(private val userRepository: UserRepository) {

    fun execute() : UserName {
        return userRepository.getName()
    }
}