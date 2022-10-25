package com.example.lab1

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun InfoScreen(navController: NavController, id: Int?) {
    Text(text="Test $id")
}