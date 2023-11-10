package com.example.lab1

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val listCards = getMarvel()
    if(listCards[0].title == "Error"){
        ErrorMessage()
    }else {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
            composable(route = Screen.MainScreen.route) {
                MainScreen(navController = navController, listCards)
            }
            composable(
                route = Screen.InfoScreen.route + "/{id}",
                arguments = listOf(
                    navArgument("id") {
                        type = NavType.IntType
                    }
                )
            ) { value ->
                InfoScreen(
                    navController = navController,
                    id = value.arguments?.getInt("id"),
                    listCards
                )
            }
        }
    }
}
