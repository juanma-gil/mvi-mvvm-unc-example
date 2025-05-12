package ar.edu.unc.fcefyn.mvimvvm.data

import ar.edu.unc.fcefyn.mvimvvm.domain.model.News
import kotlinx.coroutines.delay

class NewsRepository(private val service: NewsService) {
    suspend fun getNews(): List<News> {
        val news = service.mockApiNewsResponse()
        delay(3000) // Simulate network delay
        return news.map { it.toDomain() }
    }
}