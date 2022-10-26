package com.example.lab1

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val listCards = listOf(
        ItemRow(0, R.drawable.cap, "Captain America", Color(0xFF123EAB)),
        ItemRow(1, R.drawable.spider, "Spider-man", Color(0xFFBF9030)),
        ItemRow(2, R.drawable.iron, "Iron Man", Color(0xFFD91818)),
        ItemRow(3, R.drawable.dead, "Deadpool", Color(0xFF6C0303)),
        ItemRow(4, R.drawable.daredevil, "Daredevil", Color(0xFF2A0000)),
        ItemRow(5, R.drawable.thanos, "Thanos", Color(0xFF65247F))
    )
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(route = Screen.MainScreen.route){
            MainScreen(navController = navController, listCards)
        }
        composable(
            route = Screen.InfoScreen.route + "/{id}",
            arguments = listOf(
                navArgument("id"){
                    type = NavType.IntType
                }
            )
        ){
            value ->
            InfoScreen(navController = navController, id = value.arguments?.getInt("id"), listCards)
        }
    }
}
