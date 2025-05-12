package ar.edu.unc.fcefyn.mvimvvm.data

import ar.edu.unc.fcefyn.mvimvvm.data.model.NewsApiModel

class NewsService {
    fun mockApiNewsResponse(): List<NewsApiModel> {
        return listOf(
            NewsApiModel(
                id = 1,
                title = "Colapinto vuelve a la f1",
                author = "Juan Manuel Gil",
                body = "El piloto argentino vuelve a la máxima categoría casi 6 meses después de su última carrera para reemplazar a Doohan en Alpine"
            ),
            NewsApiModel(
                id = 2,
                title = "River vence a Boca en el superclásico",
                author = "Juan Manuel Gil",
                body = "El equipo del muñeco Gallardo vuelve a imponerse ante el eterno rival que solo ganó 2 de los últimos 10 superclásicos"
            )
        )
    }
}