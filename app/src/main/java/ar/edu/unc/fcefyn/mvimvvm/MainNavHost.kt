package ar.edu.unc.fcefyn.mvimvvm

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ar.edu.unc.fcefyn.mvimvvm.presentation.MainScreenRoot

@Composable
fun MainNavHost(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(Screen.MainScreen.route) {
            MainScreenRoot(navController)
        }
    }
}