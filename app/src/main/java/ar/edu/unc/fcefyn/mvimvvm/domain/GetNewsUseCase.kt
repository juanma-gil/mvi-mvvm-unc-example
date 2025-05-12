package ar.edu.unc.fcefyn.mvimvvm.domain

import ar.edu.unc.fcefyn.mvimvvm.data.NewsRepository
import ar.edu.unc.fcefyn.mvimvvm.domain.model.News

class GetNewsUseCase(private val repository: NewsRepository) {
    suspend operator fun invoke(): List<News> {
        // Acá puedes agregar cualquier lógica de negocio que necesites, como filtrar por fecha o autor
        return repository.getNews()
    }
}