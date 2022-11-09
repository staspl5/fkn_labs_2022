package com.example.lab1

import androidx.compose.ui.graphics.Color

data class ItemRow(
    val id: Int,
    val title: String,
    val background: Color,
    val description: String,
    val url: String
)
