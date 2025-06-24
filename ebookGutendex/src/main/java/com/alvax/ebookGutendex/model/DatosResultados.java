package com.alvax.ebookGutendex.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record DatosResultados(
        int count,
        String next,
        String previous,
        @JsonProperty("results") List<DatosLibro> resultados
) {}