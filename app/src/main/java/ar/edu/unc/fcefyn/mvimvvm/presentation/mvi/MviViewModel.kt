package ar.edu.unc.fcefyn.mvimvvm.presentation.mvi

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unc.fcefyn.mvimvvm.domain.GetNewsUseCase
import kotlinx.coroutines.launch

class MviViewModel(private val getNewsUseCase: GetNewsUseCase) : ViewModel() {
    var state by mutableStateOf(MviState())
        private set

    fun onAction(action: MviAction) {
        when (action) {
            MviAction.AskForNews -> getNews()
            // Acá irían todas las demás actions que puedas tener
        }
    }

    private fun getNews() = viewModelScope.launch {
        state = state.copy(isLoading = true)
        val news = getNewsUseCase()
        // En un caso de uso verdadero acá chequearías por errores
        state = state.copy(news = news, isLoading = false)
    }
}