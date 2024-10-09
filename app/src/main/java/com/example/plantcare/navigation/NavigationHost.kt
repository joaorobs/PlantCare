package com.example.plantcare.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.plantcare.presentation.PlantViewModel
import com.example.plantcare.presentation.screens.HomeScreen
import com.example.plantcare.presentation.screens.FormScreen

@Composable
fun NavigationHost(
    navController: NavHostController = rememberNavController(),
    viewModel: PlantViewModel = PlantViewModel()
) {
    NavHost(navController = navController, startDestination = Home) {
        composable<Home> {
            HomeScreen(navController, viewModel)
        }
        composable<FormScreen> {
            FormScreen(navController)
        }
    }

}