package com.raghav.framework.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.raghav.data.models.TaskModel

@Entity(tableName = "tasks")
data class TaskEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "priority")
    val priority: Int,
    @ColumnInfo(name = "tag")
    val tag: String,
    @ColumnInfo(name = "status")
    val status: Int
)


fun TaskEntity.toDomain():TaskModel
{
    return TaskModel(this.id, this.title, this.description, this.priority, this.tag, this.status)
}

fun TaskModel.toEntity():TaskEntity
{
    return TaskEntity(this.id, this.title, this.description, this.priority, this.tag, this.status)
}