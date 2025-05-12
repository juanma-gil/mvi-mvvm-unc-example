# MVI vs MVVM

## Descripción

Esta aplicación Android ejemplifica las diferencias entre los patrones de presentación **MVI (
Model-View-Intent)** y **MVVM (Model-View-ViewModel)**. Fue desarrollada como material educativo
para los alumnos de la clase de Ingeniería de Software de la **Universidad Nacional de Córdoba**.

El objetivo principal es demostrar cómo implementar ambos patrones en la capa de presentación,
mientras se comparte la misma capa de dominio y datos. Esto permite a los estudiantes distinguir con
mayor claridad las diferencias entre estos patrones de presentación y reforzar los conceptos de patrones arquitectónicos aprendidos en clases previas.

## Características

- Implementación de **MVI** y **MVVM** en la capa de presentación.
- Uso de **Jetpack Compose** para la interfaz de usuario.
- Simulación de una API con datos ficticios.
- Comparación práctica de cómo cada patrón maneja el estado y las acciones del usuario.

## Requisitos previos

Antes de comenzar, asegúrate de tener lo siguiente instalado:

- **Android Studio** (versión `2024.3.2` o superior recomendada).
- **JDK 17**.
- Conexión a internet para descargar dependencias de Gradle.

## Instalación

Sigue estos pasos para clonar y ejecutar el proyecto:

1. Clona este repositorio: <br>
   `git clone https://github.com/juanma-gil/mvi-mvvm-unc-example.git`<br>
   o con ssh <br> `git clone git@github.com:juanma-gil/mvi-mvvm-unc-example.git`


2. Abre el proyecto en Android Studio.

3. Sincroniza las dependencias de Gradle.

4. Ejecuta la aplicación en un emulador o dispositivo físico.

## Estructura del proyecto
El proyecto está organizado en las siguientes capas:

**Data**: Contiene la lógica de acceso a datos, incluyendo un servicio simulado (NewsService) y un repositorio (NewsRepository).<br>
**Domain**: Define los casos de uso, como GetNewsUseCase, y los modelos de dominio.<br>
**Presentation**: Implementa las interfaces de usuario y la lógica de presentación para los patrones MVI
y MVVM.

### Principales archivos y directorios
`ar.edu.unc.fcefyn.mvimvvm.presentation.mvi`: Implementación del patrón MVI.
`ar.edu.unc.fcefyn.mvimvvm.presentation.mvvm`: Implementación del patrón MVVM.
`ar.edu.unc.fcefyn.mvimvvm.data`: Lógica de acceso a datos.
`ar.edu.unc.fcefyn.mvimvvm.domain`: Casos de uso y modelos de dominio.

## Demo

https://youtube.com/shorts/tCcb1n6Ug5g

## Tecnologías utilizadas
Kotlin: Lenguaje principal del proyecto.
Jetpack Compose: Para la construcción de la interfaz de usuario declarativa.
Coroutines: Para la gestión de tareas asíncronas.
Gradle: Sistema de construcción.