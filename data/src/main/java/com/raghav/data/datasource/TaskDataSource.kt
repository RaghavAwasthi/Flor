package com.raghav.data.datasource

import com.raghav.common.StateFullResult
import com.raghav.data.models.TaskModel
import kotlinx.coroutines.flow.Flow

interface TaskDataSource {

    fun getTasksByStatus(statusCode: Int): Flow<StateFullResult<List<TaskModel>>>

    fun addTask(task: TaskModel): StateFullResult<Any>

    fun updateTask(task: TaskModel): StateFullResult<Any>

    fun deleteTask(taskID: String): StateFullResult<Any>


}