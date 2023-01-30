package com.raghav.framework.di

import androidx.room.Room
import com.raghav.data.datasource.TaskDataSource
import com.raghav.framework.db.AppDatabase
import com.raghav.framework.implementation.LocalTaskDataSourceImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val frameworkModule = module {
    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "APP_DB")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    single {
        val db = get<AppDatabase>()
        db.getTaskDao()
    }

    single<TaskDataSource> {
        LocalTaskDataSourceImpl(get())
    }
}