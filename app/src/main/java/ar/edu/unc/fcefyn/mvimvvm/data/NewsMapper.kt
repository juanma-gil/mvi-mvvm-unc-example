package ar.edu.unc.fcefyn.mvimvvm.data

import ar.edu.unc.fcefyn.mvimvvm.data.model.NewsApiModel
import ar.edu.unc.fcefyn.mvimvvm.domain.model.News

fun NewsApiModel.toDomain() = News(
    title = title,
    author = author,
    body = body
)