package com.loc.catapp


import CatListScreen
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.loc.catapp.view.CatDetailScreen

@Composable
fun CatApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.CatList.route) {
        composable(Screen.CatList.route) {
            CatListScreen(navController)
        }
        composable(Screen.CatDetail.route) { backStackEntry ->
            val catId = backStackEntry.arguments?.getString("catId")
            catId?.let {
                CatDetailScreen(catId = it)
            }
        }
    }
}



