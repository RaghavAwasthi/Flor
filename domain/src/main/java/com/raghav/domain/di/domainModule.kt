package com.raghav.domain.di

import com.raghav.domain.usecases.tasks.AddTaskUseCase
import com.raghav.domain.usecases.tasks.GetAllTaskUseCase
import com.raghav.domain.usecases.tasks.UpdateTaskUseCase
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val domainModule = module {

    factory { AddTaskUseCase(get(), getIODispatcher()) }
    factory { GetAllTaskUseCase(get()) }
    factory { UpdateTaskUseCase(get(), getIODispatcher()) }


}

fun getIODispatcher() = Dispatchers.IO

fun getMainDispatcher()= Dispatchers.Main

