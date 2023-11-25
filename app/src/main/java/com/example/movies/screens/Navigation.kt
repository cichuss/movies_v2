package com.example.movies.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
const val MAIN_SCREEN_ROUTE = "MainScreen"
const val DESCRIPTION_ROUTE = "DescriptionScreen/{movieId}"
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MAIN_SCREEN_ROUTE) {
        composable(MAIN_SCREEN_ROUTE) {
            MainScreen(navController)
        }
        composable(
            DESCRIPTION_ROUTE,
            arguments = listOf(navArgument("movieId") { type = NavType.IntType })
        ) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getInt("movieId") ?: 0
            DescriptionScreen(movieId = movieId)
        }
    }
}