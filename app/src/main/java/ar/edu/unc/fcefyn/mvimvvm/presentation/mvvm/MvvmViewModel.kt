package ar.edu.unc.fcefyn.mvimvvm.presentation.mvvm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unc.fcefyn.mvimvvm.domain.GetNewsUseCase
import ar.edu.unc.fcefyn.mvimvvm.domain.model.News
import kotlinx.coroutines.launch

class MvvmViewModel(private val getNewsUseCase: GetNewsUseCase) : ViewModel() {
    var isLoading: Boolean by mutableStateOf(false)
        private set
    var news: List<News> by mutableStateOf(emptyList())
        private set
    var error: String? by mutableStateOf(null)
        private set

    fun getNews() = viewModelScope.launch {
        isLoading = true
        val result = getNewsUseCase()
        // En un caso de uso verdadero acá chequearías por errores
        news = result
        isLoading = false
    }
}