package com.bookwise_api.domain.Book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record BookCreateDTO(

        @NotBlank
        String title,

        @NotBlank
        String author,

        @NotNull
        Genre genre,

        @NotNull @Positive
        Integer pageNumber,

        @NotBlank @Size(max = 1000)
        String synopsis
) {

}
