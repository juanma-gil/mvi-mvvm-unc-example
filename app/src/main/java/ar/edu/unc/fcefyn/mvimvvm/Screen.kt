package ar.edu.unc.fcefyn.mvimvvm

sealed class Screen(val route: String) {
    data object MainScreen: Screen("main")
    data object MviScreen: Screen("mvi")
    data object MvvmScreen: Screen("mvvm")
}