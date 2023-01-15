package com.project.tasks

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table") // This tells Room that the class describes the task_table entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    var taskId: Long = 0L,
    @ColumnInfo(name= "task_name")
    var taskName: String = "",
    @ColumnInfo(name= "task_done")
    var taskDone: Boolean = false
)
