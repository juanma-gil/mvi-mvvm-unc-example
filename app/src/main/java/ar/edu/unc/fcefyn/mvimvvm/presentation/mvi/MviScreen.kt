package ar.edu.unc.fcefyn.mvimvvm.presentation.mvi

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ar.edu.unc.fcefyn.mvimvvm.domain.model.News
import ar.edu.unc.fcefyn.mvimvvm.presentation.component.NewsComponent

@Composable
fun MviScreenRoot(
    viewModel: MviViewModel,
    navController: NavController
) {
    MviScreen(state = viewModel.state, onAction = { action ->
        when (action) {
            MviAction.AskForNews -> viewModel.onAction(action)
            MviAction.OnBack -> navController.popBackStack()
        }
    })
}

@Composable
fun MviScreen(state: MviState, onAction: (MviAction) -> Unit) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        if (state.isLoading) {
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
                items(state.news) { newsItem ->
                    NewsComponent(
                        title = newsItem.title,
                        body = newsItem.body,
                        author = newsItem.author
                    )
                }
                item {
                    Button(onClick = { onAction(MviAction.AskForNews) }) {
                        Text(text = "Get news")
                    }
                }
                item {
                    Button(onClick = { onAction(MviAction.OnBack) }) {
                        Text(text = "Back")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun MviScreenPreview() {
    MviScreen(
        state = MviState(
            news = listOf(
                News(
                    title = "Title",
                    body = "Body",
                    author = "Author"
                ),
                News(
                    title = "Title",
                    body = "Body",
                    author = "Author"
                ),
            )
        )
    ) {}
}