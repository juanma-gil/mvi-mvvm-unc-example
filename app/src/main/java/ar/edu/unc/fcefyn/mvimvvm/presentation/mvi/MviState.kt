package ar.edu.unc.fcefyn.mvimvvm.presentation.mvi

import ar.edu.unc.fcefyn.mvimvvm.domain.model.News

data class MviState(
    val isLoading: Boolean = false,
    val news: List<News> = emptyList(),
    val error: String? = null
)
