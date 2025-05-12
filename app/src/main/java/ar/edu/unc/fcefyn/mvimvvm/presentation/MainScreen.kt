package ar.edu.unc.fcefyn.mvimvvm.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ar.edu.unc.fcefyn.mvimvvm.Screen

@Composable
fun MainScreenRoot(
    navController: NavHostController,
) {
    MainScreen(
        navToMVI = { navController.navigate(Screen.MviScreen.route) },
        navToMVVM = { navController.navigate(Screen.MvvmScreen.route) })
}

@Composable
fun MainScreen(navToMVI: () -> Unit = {}, navToMVVM: () -> Unit = {}) {
    Scaffold { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Elegí un patrón de presentación",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(32.dp))
            Button(onClick = navToMVVM) {
                Text(text = "MVVM", fontSize = 24.sp)
            }
            Spacer(Modifier.height(16.dp))
            Button(onClick = navToMVI) {
                Text(text = "MVI", fontSize = 24.sp)
            }
        }
    }

}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}