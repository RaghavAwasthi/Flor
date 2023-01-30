package com.raghav.flor

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.raghav.data.models.TaskModel
import com.raghav.flor.databinding.ActivityTaskBinding
import com.raghav.presentation.viewmodels.TaskViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class TaskActivity : AppCompatActivity() {
    lateinit var bind: ActivityTaskBinding
    val addTaskViewModel by viewModel<TaskViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityTaskBinding.inflate(layoutInflater)
        setContentView(bind.root)
        initUI()
        initObserver()

    }

    private fun initObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED)
            {
                addTaskViewModel.addTaskUIState.collect {
                    if (!it.isSuccess) {
                        Log.d("RAGHAV", "Error")
                    } else if (it.isLoading) {
                        Log.d("RAGHAV", "Loading")
                    } else {
                        Log.d("RAGHAV", " Data aaya ${it.payload}")
                    }
                }
            }
        }

    }

    private fun initUI() {
        bind.fabAddTask.setOnClickListener {
            addTaskViewModel.addTask(
                TaskModel(
                    id = UUID.randomUUID().toString(),
                    title = "Some Shit",
                    description = "Some Description",
                    priority = 2,
                    tag = "Productivity",
                    status = 2
                )
            )
        }
    }
}