package com.raghav.data.repo.abstractions

import com.raghav.common.StateFullResult
import com.raghav.data.models.TaskModel
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getTasksByStatus(statusCode:Int): Flow<StateFullResult<List<TaskModel>>>

    fun addTask(task: TaskModel): StateFullResult<Any>

    fun updateTask(task: TaskModel): StateFullResult<Any>

    fun deleteTask(taskID: String): StateFullResult<Any>
}