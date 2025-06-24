# Buscador de Libros - Gutendex API

Esta aplicación Java permite buscar y explorar libros utilizando la API pública de Gutendex. Proporciona un menú interactivo para realizar diferentes tipos de búsquedas y obtener información detallada sobre libros.

## Características principales

- Búsqueda de libros por título
- Búsqueda por autor (filtrado desde 1800)
- Top 10 libros más descargados
- Búsqueda por idioma (inglés, francés, etc.)
- Búsqueda por tema (ficción, ciencia, etc.)
- Filtrado de libros populares (+25000 descargas)

## Requisitos

- Java 17 o superior
- Maven (para gestión de dependencias)

## Instalación y ejecución

1. Clona el repositorio:
```bash
git clone https://github.com/tu-usuario/buscador-libros-gutendex.git
cd buscador-libros-gutendex
```

2. Compila y ejecuta la aplicación:
```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.alvax.ebookGutendex.principal.Principal"
```

## Uso

Al iniciar la aplicación, se mostrará un menú con las siguientes opciones:

```
==== MENÚ PRINCIPAL ====
1. Buscar libros por título
2. Buscar libros por autor
3. Top 10 libros más descargados
4. Libros por idioma
5. Buscar libros por tema
6. Libros con más de 25000 descargas
7. Salir
```

Selecciona una opción ingresando el número correspondiente y sigue las instrucciones.

## Ejemplos de búsqueda

- Buscar "Don Quijote" por título
- Buscar libros de "Julio Verne"
- Ver los libros más descargados
- Buscar libros en inglés (código "en")
- Explorar libros de "Science Fiction"

## Estructura del proyecto

```
src/main/java/
├── com.alvax.ebookGutendex
│   ├── model/       # Modelos de datos
│   ├── principal/   # Lógica principal de la aplicación
│   └── service/     # Servicios para consumo de API
```

## Tecnologías utilizadas

- Java 17
- HttpClient (para peticiones HTTP)
- Jackson (para procesamiento JSON)
- Maven (gestión de dependencias)

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue o pull request para sugerir mejoras.
