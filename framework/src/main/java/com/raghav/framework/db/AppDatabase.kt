package com.raghav.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.raghav.framework.entities.TaskEntity

@Database(entities = [TaskEntity::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase()
{
    abstract fun getTaskDao():TaskDao
}