package com.raghav.data.repo.implementation

import com.raghav.common.StateFullResult
import com.raghav.data.datasource.TaskDataSource
import com.raghav.data.models.TaskModel
import com.raghav.data.repo.abstractions.TaskRepository
import kotlinx.coroutines.flow.Flow


class TaskRepositoryImpl(
   val localTaskDataSource: TaskDataSource
):TaskRepository {
    override fun getTasksByStatus(statusCode: Int): Flow<StateFullResult<List<TaskModel>>> {
        return localTaskDataSource.getTasksByStatus(statusCode)
    }

    override fun addTask(task: TaskModel): StateFullResult<Any> {
        return localTaskDataSource.addTask(task)
    }

    override fun updateTask(task: TaskModel): StateFullResult<Any> {
     return localTaskDataSource.updateTask(task)
    }

    override fun deleteTask(taskID: String): StateFullResult<Any> {
    return localTaskDataSource.deleteTask(taskID)
    }
}