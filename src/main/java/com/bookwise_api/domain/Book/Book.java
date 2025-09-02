package com.bookwise_api.domain.Book;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "Books")
@Entity(name = "Book")

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private Integer pageNumber;
    private String synopsis;
    private Boolean active = true;

    public Book(BookCreateDTO data) {
        this.title = data.title();
        this.author = data.author();
        this.genre = data.genre();
        this.pageNumber = data.pageNumber();
        this.synopsis = data.synopsis();
    }

    public void updateData(BookUpdateDataDTO data) {
        if (data.title() != null) {
            this.title = data.title();
        }
        if (data.author() != null) {
            this.author = data.author();
        }
        if (data.genre() != null) {
            this.genre = data.genre();
        }
        if (data.pageNumber() != null) {
            this.pageNumber = data.pageNumber();
        }
        if (data.synopsis() != null) {
            this.synopsis = data.synopsis();
        }
    }

    public void deactivate() {
        this.active = false;
    }

}
