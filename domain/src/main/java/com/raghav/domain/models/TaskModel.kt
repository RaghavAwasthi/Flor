package com.raghav.domain.models

data class TaskModel(
    val id: String,
    val title: String,
    val description: String,
    val priority: Int,
    val tag: String,
    val status: Int
)