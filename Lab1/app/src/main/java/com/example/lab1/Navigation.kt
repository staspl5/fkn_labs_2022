package com.example.lab1

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kotlinx.coroutines.launch

@Composable
fun Navigation() {
    val listCards = getMarvel()
    val listCards1 = listOf(
        ItemRow(0, R.drawable.cap, "Captain America", Color(0xFF123EAB),"Ass of the America" , "https://avatars.mds.yandex.net/i?id=59c1399007c8c01a11a4a6d899211772_l-5239483-images-thumbs&n=13"),
        ItemRow(1, R.drawable.spider, "Spider-man", Color(0xFFBF9030), "Uncle Ben is dead", "https://avatars.mds.yandex.net/i?id=b2a3868c072b85ac12fd6eaf68c4530b_l-4599171-images-thumbs&n=13"),
        ItemRow(2, R.drawable.iron, "Iron Man", Color(0xFFD91818), "Genius, Billionaire, Playboy, Philanthropist","https://avatars.mds.yandex.net/i?id=e28f13cc2c905e1ad2161b93d6626f8f_l-5226766-images-thumbs&n=13"),
        ItemRow(3, R.drawable.dead, "Deadpool", Color(0xFF6C0303), "I am wolverine", "https://avatars.mds.yandex.net/i?id=a8122f708696bad934161e4d29ae8f7c_l-4988204-images-thumbs&n=13"),
        ItemRow(4, R.drawable.daredevil, "Daredevil", Color(0xFF2A0000), "Just blind and lawyer", "https://i.pinimg.com/originals/a9/b7/3a/a9b73a62ecfafe618c0c971fddbf21c3.jpg"),
        ItemRow(5, R.drawable.thanos, "Thanos", Color(0xFF65247F), "I am the inevitability itself", "https://avatars.mds.yandex.net/i?id=3e7d0f80f0d2ded88dca5f21a673baba_l-5602641-images-thumbs&n=13")
    )
    if(listCards[0].title == "Error"){
        errorMessage()
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
