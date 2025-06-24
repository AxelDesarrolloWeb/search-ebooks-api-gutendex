package com.alvax.ebookGutendex;

import com.alvax.ebookGutendex.model.DatosResultados;
import com.alvax.ebookGutendex.principal.Principal;
import com.alvax.ebookGutendex.service.ConsumoAPI;
import com.alvax.ebookGutendex.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EbookGutendexApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EbookGutendexApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("¡Bienvenido al Buscador de Libros de Gutendex!");

		String baseUrl = "https://gutendex.com/books";

		ConsumoAPI consumoAPI = new ConsumoAPI();
		String json = consumoAPI.obtenerDatos(baseUrl + "?languages=en");

		// Verificar si la respuesta es válida
		if (json == null || json.isEmpty()) {
			System.err.println("Error: No se recibieron datos de la API");
			return;
		}

		System.out.println("JSON recibido (primeros 500 caracteres):\n" + json.substring(0, Math.min(json.length(), 500)) + "...");

		ConvierteDatos conversor = new ConvierteDatos();
		DatosResultados datos = conversor.obtenerDatos(json, DatosResultados.class);

		if (datos == null || datos.resultados() == null || datos.resultados().isEmpty()) {
			System.err.println("Error: No se encontraron libros en la respuesta");
			return;
		}

		System.out.println("\n=== Libros obtenidos ===");
		datos.resultados().forEach(libro -> {
			// Manejo seguro de autores
			String autor = "Desconocido";
			if (libro.autores() != null && !libro.autores().isEmpty()) {
				autor = libro.autores().get(0).name();
			}
			System.out.println(libro.title() + " - " + autor);
		});


		Principal principal = new Principal();
		principal.muestraElMenu();
	}
}