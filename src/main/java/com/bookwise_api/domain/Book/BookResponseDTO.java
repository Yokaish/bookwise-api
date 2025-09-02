package com.bookwise_api.domain.Book;

public record BookResponseDTO(

        String title,
        String author,
        String genre

) {

    public BookResponseDTO(Book book) {
        this(book.getTitle(), book.getAuthor(), book.getGenre().getName());
    }

}
