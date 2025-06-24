package com.alvax.ebookGutendex.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ConsumoAPI {
    public String obtenerDatos(String url) {
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .followRedirects(HttpClient.Redirect.ALWAYS) // Manejar redirecciones
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofSeconds(15))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar redirecciones manualmente
            if (response.statusCode() >= 300 && response.statusCode() < 400) {
                String newUrl = response.headers().firstValue("Location").orElse(url);
                System.out.println("Redireccionando a: " + newUrl);
                return obtenerDatos(newUrl); // Llamada recursiva
            }

            if (response.statusCode() != 200) {
                System.err.println("Error en la respuesta: Código " + response.statusCode());
                return null;
            }

            return response.body();
        } catch (IOException | InterruptedException e) {
            System.err.println("Error al obtener datos: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
            return null;
        }
    }
}