package com.raghav.data.di

import com.raghav.data.repo.abstractions.TaskRepository
import com.raghav.data.repo.implementation.TaskRepositoryImpl
import org.koin.dsl.module

val dataModule= module {

    single<TaskRepository> {
        TaskRepositoryImpl(get())
    }
}