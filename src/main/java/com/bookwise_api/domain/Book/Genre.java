package com.bookwise_api.domain.Book;

import lombok.Getter;

@Getter
public enum Genre {

    POETRY("Poetry"),
    NOVEL("Novel"),
    FANTASY("Fantasy"),
    FICTION("Fiction"),
    NON_FICTION("Non-Fiction"),
    SCIENCE_FICTION("Science Fiction"),
    MYSTERY("Mystery"),
    SUSPENSE("Suspense"),
    HORROR("Horror"),
    BIOGRAPHY("Biography"),
    HISTORICAL_FICTION("Historical Fiction");

    private final String name;

    Genre(String name) {
        this.name = name;
    }
}
