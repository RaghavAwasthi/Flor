package com.raghav.flor.tasks.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView
import com.raghav.common.exceptions.CommonException
import com.raghav.data.models.TaskModel
import com.raghav.flor.databinding.ItemTaskBinding
import com.raghav.flor.databinding.ItemTaskCreateBinding

class TaskListAdapter(
    val items: List<TaskListDataModel>,
    val onClickItemAdd: () -> Unit,
    val onClickItem: () -> Unit
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TaskViewType.TASK_ITEM.ordinal -> TaskItemViewHolder(
                ItemTaskBinding.inflate(
                    LayoutInflater.from(parent.context)
                )
            )
            TaskViewType.TASK_ITEM_CREATE.ordinal -> TaskItemCreateViewHolder(
                ItemTaskCreateBinding.inflate(
                    LayoutInflater.from(parent.context)
                )
            )
            else -> throw  CommonException.IllegalViewHolderException
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is TaskItemCreateViewHolder -> {
                holder.bind.root.setOnClickListener { onClickItemAdd.invoke() }
            }
            is TaskItemViewHolder -> {
                holder.bind.root.setOnClickListener { onClickItem.invoke() }
            }
            else -> throw CommonException.IllegalViewHolderException
        }

    }

    inner class TaskItemViewHolder(val bind: ItemTaskBinding) :
        RecyclerView.ViewHolder(bind.root)

    inner class TaskItemCreateViewHolder(val bind: ItemTaskCreateBinding) :
        RecyclerView.ViewHolder(bind.root)

    enum class TaskViewType {
        TASK_ITEM_CREATE,
        TASK_ITEM
    }
}


sealed class TaskListDataModel {
    data class CreateTaskDataModel(@StringRes val createTaskText: Int) : TaskListDataModel()
    data class TaskDataModel(val task: TaskModel) : TaskListDataModel()
}