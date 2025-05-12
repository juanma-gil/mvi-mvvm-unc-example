package ar.edu.unc.fcefyn.mvimvvm.data.model

import androidx.compose.runtime.Immutable

@Immutable
data class NewsApiModel(
    val id: Int,
    val title: String,
    val author: String,
    val body: String,
)