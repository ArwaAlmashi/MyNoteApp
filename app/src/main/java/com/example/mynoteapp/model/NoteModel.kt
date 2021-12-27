package com.example.mynoteapp.model

import java.io.Serializable

data class NoteModel (
    val id: Int,
    var title: String,
    var tasks: ArrayList<Task>,
    var isComplete: Boolean = false,
    val date: String
) :Serializable