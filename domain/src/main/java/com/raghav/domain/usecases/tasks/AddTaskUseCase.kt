package com.raghav.domain.usecases.tasks

import com.raghav.common.*
import com.raghav.data.models.TaskModel
import com.raghav.data.repo.abstractions.TaskRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class AddTaskUseCase(
    private val repo: TaskRepository,
    private val taskDispatcher: CoroutineDispatcher
) : SuspendUseCase<Any, AddTaskUseCase.AddTaskParams>(taskDispatcher) {
    data class AddTaskParams(val task:TaskModel):UseCaseParams()

    override suspend fun launch(params: AddTaskParams): StateFullResult<Any> {
       return autoResult {
            repo.addTask(params.task)
        }

    }


}