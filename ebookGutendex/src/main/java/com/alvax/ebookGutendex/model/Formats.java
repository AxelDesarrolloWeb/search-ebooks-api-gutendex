package com.alvax.ebookGutendex.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Formats(
        @JsonAlias("text/html") String html,
        @JsonAlias("application/epub+zip") String epub,
        @JsonAlias("application/x-mobipocket-ebook") String mobi,
        @JsonAlias("application/rdf+xml") String rdf,
        @JsonAlias("image/jpeg") String imageJpeg,
        @JsonAlias("text/plain") String plainText,
        @JsonAlias("text/plain; charset=us-ascii") String asciiText
) {}