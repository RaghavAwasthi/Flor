package com.raghav.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raghav.common.BaseViewModel
import com.raghav.common.onFailure
import com.raghav.common.onSuccess
import com.raghav.data.models.TaskModel
import com.raghav.domain.usecases.tasks.AddTaskUseCase
import com.raghav.domain.usecases.tasks.GetAllTaskUseCase
import com.raghav.domain.usecases.tasks.UpdateTaskUseCase
import com.raghav.presentation.states.AddTaskState
import com.raghav.presentation.states.AllTaskState
import com.raghav.presentation.states.UpdateTaskState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TaskViewModel(
    val addTaskUseCase: AddTaskUseCase,
    val getAllTaskUSeCAse: GetAllTaskUseCase,
    val updateTaskUseCase: UpdateTaskUseCase
) : BaseViewModel() {

    private val _addTaskUIState = MutableStateFlow(AddTaskState())
    private val _allTasksUIState = MutableStateFlow(AllTaskState())
    private val _updateTaskUIState = MutableStateFlow(UpdateTaskState())

    // The UI collects from this StateFlow to get its state updates
    val addTaskUIState: StateFlow<AddTaskState> = _addTaskUIState
    val allTaskUIState: StateFlow<AllTaskState> = _allTasksUIState
    val updateTaskUIState: StateFlow<UpdateTaskState> = _updateTaskUIState


    fun fetchAllTask(taskStatus: Int) {

        viewModelScope.launch {
            _allTasksUIState.value = _allTasksUIState.value.copy(isLoading = true)
            getAllTaskUSeCAse.launch(GetAllTaskUseCase.GetAllTaskUseCaseParams(taskStatus))
                .collect {

                    it.onSuccess { tasks ->
                        _allTasksUIState.value =
                            _allTasksUIState.value.copy(isLoading = false).apply {
                                isSuccess = true
                                payload = tasks
                            }

                    }
                        .onFailure {
                            _allTasksUIState.value =
                                _allTasksUIState.value.copy(isLoading = false).apply {
                                    isSuccess = false
                                    payload = null
                                }
                        }

                }
        }


    }


    fun updateTaskStatus(taskModel: TaskModel) {
        viewModelScope.launch {

            _updateTaskUIState.value = _updateTaskUIState.value.copy(isLoading = true)
            updateTaskUseCase.execute(UpdateTaskUseCase.UpdateTaskParams(taskModel))
                .onSuccess {
                    _updateTaskUIState.value =
                        _updateTaskUIState.value.copy(isLoading = false).apply {
                            payload = taskModel
                            isSuccess = true
                        }
                }
                .onFailure {

                }

        }
    }


    fun addTask(taskModel: TaskModel) {

        viewModelScope.launch {

            _addTaskUIState.value = _addTaskUIState.value.copy(isLoading = true)
            addTaskUseCase.execute(AddTaskUseCase.AddTaskParams(taskModel))
                .onSuccess {
                    _addTaskUIState.value = _addTaskUIState.value.copy(isLoading = false).apply {
                        payload = taskModel
                        isSuccess = true
                    }
                }.onFailure {
                    _addTaskUIState.value = _addTaskUIState.value.copy(isLoading = false).apply {
                        payload = null
                        isSuccess = false
                    }
                }
        }

    }


}