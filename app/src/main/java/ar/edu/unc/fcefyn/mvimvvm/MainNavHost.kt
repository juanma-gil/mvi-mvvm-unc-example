package ar.edu.unc.fcefyn.mvimvvm

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ar.edu.unc.fcefyn.mvimvvm.data.NewsRepository
import ar.edu.unc.fcefyn.mvimvvm.data.NewsService
import ar.edu.unc.fcefyn.mvimvvm.domain.GetNewsUseCase
import ar.edu.unc.fcefyn.mvimvvm.presentation.MainScreenRoot
import ar.edu.unc.fcefyn.mvimvvm.presentation.mvvm.MvvmScreenRoot
import ar.edu.unc.fcefyn.mvimvvm.presentation.mvvm.MvvmViewModel

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun MainNavHost(
    navController: NavHostController,
) {
    val newsRepository = NewsRepository(NewsService())
    val getNewsUseCase = GetNewsUseCase(newsRepository)

    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(Screen.MainScreen.route) {
            MainScreenRoot(navController)
        }

        composable(Screen.MvvmScreen.route) {
            // Esto no debería ir acá, lo pongo para simplificar el ejemplo
            val mvvmViewModel = MvvmViewModel(getNewsUseCase)

            MvvmScreenRoot(
                viewModel = mvvmViewModel,
                navController = navController
            )
        }
    }
}