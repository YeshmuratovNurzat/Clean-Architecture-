package com.etoolkit.clean.presentation.di

import com.etoolkit.domain.domain.usecase.GetNameUseCase
import com.etoolkit.domain.domain.usecase.SaveNameUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetNameUseCase> {
        GetNameUseCase(userRepository = get())
    }

    factory<SaveNameUseCase> {
        SaveNameUseCase(userRepository = get())
    }
}