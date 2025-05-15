package ar.edu.unc.fcefyn.mvimvvm.presentation.mvvm

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonSkippableComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ar.edu.unc.fcefyn.mvimvvm.domain.model.News
import ar.edu.unc.fcefyn.mvimvvm.presentation.component.NewsComponent

@Composable
fun MvvmScreenRoot(
    viewModel: MvvmViewModel,
    navController: NavController
) {
    MvvmScreen(
        isLoading = viewModel.isLoading,
        error = viewModel.error,
        news = viewModel.news,
        onGetNews = {
            viewModel.getNews()
        },
        onBack = {
            navController.popBackStack()
        }
    )
}

@Composable
@NonSkippableComposable
fun MvvmScreen(
    isLoading: Boolean = false,
    error: String? = null,
    news: List<News>,
    onGetNews: () -> Unit,
    onBack: () -> Unit
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        if (isLoading) {
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = innerPadding
            ) {
                items(news) { newsItem ->
                    NewsComponent(
                        title = newsItem.title,
                        body = newsItem.body,
                        author = newsItem.author
                    )
                }
                item {
                    Button(onClick = onGetNews) {
                        Text(text = "Get news")
                    }
                }
                item {
                    Button(onClick = onBack) {
                        Text(text = "Back")
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun MvvmScreenPreview() {
    var isLoading by remember { mutableStateOf(false) }
    MvvmScreen(
        isLoading = isLoading,
        news = listOf(
            News(
                title = "Test title",
                author = "Test author",
                body = "Test body"
            ),
            News(
                title = "Test title 2",
                author = "Test author 2",
                body = "Test body 2"
            )
        ),
        onGetNews = {
            isLoading = true
        },
        onBack = {}
    )
}