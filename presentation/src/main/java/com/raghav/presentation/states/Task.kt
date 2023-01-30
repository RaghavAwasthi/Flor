package com.raghav.presentation.states

import com.raghav.data.models.TaskModel


data class AddTaskState(
    override var isLoading: Boolean = false
) : State<TaskModel>()

data class AllTaskState(
    override var isLoading: Boolean = false
) : State<List<TaskModel>>()

data class UpdateTaskState(override var isLoading: Boolean= false): State<TaskModel>()