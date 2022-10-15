package com.raghav.framework.db

import androidx.room.*
import com.raghav.framework.entities.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Insert
    fun addTask(taskEntity: TaskEntity)

    @Query("SElECT * FROM tasks WHERE id == :taskId")
    fun getTasksById(taskId: String): TaskEntity

    @Query("SElECT * FROM tasks WHERE status == :status")
    fun getTasksByStatus(status: Int): Flow<List<TaskEntity>>

    @Delete
    fun deleteTask(task: TaskEntity)

    @Update
    fun updateTask(task: TaskEntity)

//    @Query("SElECT * FROM tasks WHERE id == :taskId")
//    fun getTasksById(taskId: String)


}