package com.alvax.ebookGutendex.model;

import java.util.List;

public class Libro {
    private int id;
    private String titulo;
    private List<String> autores;
    private List<String> temas;
    private String idioma;
    private int descargas;
    private String urlTexto;

    public Libro(DatosLibro datosLibro) {
        this.id = datosLibro.id();
        this.titulo = datosLibro.title();
        this.autores = datosLibro.autores().stream()
                .map(DatosAutor::name)
                .toList();
        this.temas = datosLibro.subjects();
        this.idioma = !datosLibro.languages().isEmpty() ?
                datosLibro.languages().get(0) : "Desconocido";
        this.descargas = datosLibro.downloadCount();
        this.urlTexto = datosLibro.formats().plainText() != null ?
                datosLibro.formats().plainText() :
                datosLibro.formats().asciiText();
    }

    // Getters
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public List<String> getAutores() { return autores; }
    public List<String> getTemas() { return temas; }
    public String getIdioma() { return idioma; }
    public int getDescargas() { return descargas; }
    public String getUrlTexto() { return urlTexto; }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autores=" + autores +
                ", idioma='" + idioma + '\'' +
                ", descargas=" + descargas +
                '}';
    }
}