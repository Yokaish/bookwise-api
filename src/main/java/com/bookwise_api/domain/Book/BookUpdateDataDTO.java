package com.bookwise_api.domain.Book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record BookUpdateDataDTO(

        @NotBlank
        @Size(max = 255, min = 1) String title,
        @Size(max = 255, min = 1) String author,
        Genre genre,
        @Positive Integer pageNumber,
        @Size(max = 1000, min = 1) String synopsis
) {
    public BookUpdateDataDTO(Book book) {
        this(book.getTitle(), book.getAuthor(), book.getGenre(), book.getPageNumber(), book.getSynopsis());
    }
}
