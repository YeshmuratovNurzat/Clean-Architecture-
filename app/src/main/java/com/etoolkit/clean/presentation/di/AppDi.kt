package com.etoolkit.clean.presentation.di

import com.etoolkit.clean.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {


    viewModel<MainViewModel> {
        MainViewModel(
            getNameUseCase = get(),
            saveNameUseCase = get()
        )
    }
}