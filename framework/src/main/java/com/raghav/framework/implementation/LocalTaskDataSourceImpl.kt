package com.raghav.framework.implementation

import com.raghav.common.StateFullResult
import com.raghav.common.autoResult
import com.raghav.common.flowResult
import com.raghav.data.datasource.TaskDataSource
import com.raghav.data.models.TaskModel
import com.raghav.framework.db.TaskDao
import com.raghav.framework.entities.toDomain
import com.raghav.framework.entities.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class LocalTaskDataSourceImpl(val taskDao: TaskDao) : TaskDataSource {
    override fun getTasksByStatus(statusCode: Int): Flow<StateFullResult<List<TaskModel>>> {
        return flow {
            emit(StateFullResult.loading())
            taskDao.getTasksByStatus(statusCode)
                .catch { e ->
                    emit(StateFullResult.failed(Exception(e)))
                }
                .collect { list ->
                    emit(StateFullResult.success(list.map { it.toDomain() }))
                }
        }
    }


    override fun addTask(task: TaskModel): StateFullResult<Any> {
        return autoResult {
            taskDao.addTask(task.toEntity())
            StateFullResult.success(Any())
        }
    }

    override fun updateTask(task: TaskModel): StateFullResult<Any> {
        return autoResult {
            taskDao.updateTask(task.toEntity())
            StateFullResult.success(Any())
        }
    }

    override fun deleteTask(taskID: String): StateFullResult<Any> {
        return autoResult {
            taskDao.deleteTask(taskDao.getTasksById(taskID))
            StateFullResult.success(Any())
        }
    }
}