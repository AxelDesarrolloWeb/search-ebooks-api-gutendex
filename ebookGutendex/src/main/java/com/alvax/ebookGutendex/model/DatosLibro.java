package com.alvax.ebookGutendex.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        int id,
        String title,
        @JsonAlias("authors") List<DatosAutor> autores,
        List<String> subjects,
        List<String> bookshelves,
        List<String> languages,
        boolean copyright,
        @JsonAlias("media_type") String mediaType,
        @JsonAlias("download_count") int downloadCount,
        Formats formats
) {}