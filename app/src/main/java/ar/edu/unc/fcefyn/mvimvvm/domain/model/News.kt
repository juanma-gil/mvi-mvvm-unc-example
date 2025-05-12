package ar.edu.unc.fcefyn.mvimvvm.domain.model

import androidx.compose.runtime.Immutable

@Immutable
data class News(
    val title: String,
    val author: String,
    val body: String
)