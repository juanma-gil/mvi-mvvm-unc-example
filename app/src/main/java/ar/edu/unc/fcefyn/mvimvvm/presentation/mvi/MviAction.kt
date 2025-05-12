package ar.edu.unc.fcefyn.mvimvvm.presentation.mvi

sealed interface MviAction {
    data object AskForNews : MviAction
    /**
     * Acá podrías tener todas las acciones del usuario necesarias como por ejemplo
     * hideNew para esconder una noticia que ya leíste, o onLikeNew para marcar una noticia como
     * favorita (acción que podría llamar al backend para guardar esa info en la DB), etc.
     */
}