package com.raghav.domain.usecases.tasks

import com.raghav.common.FlowUseCase
import com.raghav.common.StateFullResult
import com.raghav.common.UseCaseParams
import com.raghav.data.models.TaskModel
import com.raghav.data.repo.abstractions.TaskRepository
import kotlinx.coroutines.flow.Flow

class GetAllTaskUseCase(val taskRepository: TaskRepository) :
    FlowUseCase<List<TaskModel>, GetAllTaskUseCase.GetAllTaskUseCaseParams>() {

    data class GetAllTaskUseCaseParams(val taskStatus: Int) : UseCaseParams()

    override fun launch(params: GetAllTaskUseCaseParams): Flow<StateFullResult<List<TaskModel>>> {
        return taskRepository.getTasksByStatus(
            params.taskStatus
        )

    }

}