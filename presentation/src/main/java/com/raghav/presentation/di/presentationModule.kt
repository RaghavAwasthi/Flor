package com.raghav.presentation.di

import com.raghav.presentation.viewmodels.TaskViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {


    viewModel { TaskViewModel(get(), get(), get()) }


}