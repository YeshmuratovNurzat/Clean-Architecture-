package com.etoolkit.clean.presentation.di

import com.etoolkit.data.repository.UserRepositoryImpl
import com.etoolkit.data.repository.storage.SharedPrefUserStorage
import com.etoolkit.data.repository.storage.UserStorage
import com.etoolkit.domain.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}