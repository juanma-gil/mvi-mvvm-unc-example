package ar.edu.unc.fcefyn.mvimvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.navigation.compose.rememberNavController
import ar.edu.unc.fcefyn.mvimvvm.data.NewsRepository
import ar.edu.unc.fcefyn.mvimvvm.data.NewsService
import ar.edu.unc.fcefyn.mvimvvm.domain.GetNewsUseCase
import ar.edu.unc.fcefyn.mvimvvm.presentation.mvvm.MvvmViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                MainNavHost(navController = rememberNavController())
            }
        }
    }
}