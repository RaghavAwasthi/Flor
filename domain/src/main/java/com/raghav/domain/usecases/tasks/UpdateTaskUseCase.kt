package com.raghav.domain.usecases.tasks

import com.raghav.common.StateFullResult
import com.raghav.common.SuspendUseCase
import com.raghav.common.UseCaseParams
import com.raghav.common.autoResult
import com.raghav.data.models.TaskModel
import com.raghav.data.repo.abstractions.TaskRepository
import kotlinx.coroutines.CoroutineDispatcher

class UpdateTaskUseCase(
   val taskRepository: TaskRepository,
    dispatcher: CoroutineDispatcher) : SuspendUseCase<Any, UpdateTaskUseCase.UpdateTaskParams>(dispatcher) {

    data class UpdateTaskParams(val taskModel: TaskModel,): UseCaseParams()

    override suspend fun launch(params: UpdateTaskParams): StateFullResult<Any> {
        return  autoResult {
            taskRepository.updateTask(params.taskModel)

        }
    }
}