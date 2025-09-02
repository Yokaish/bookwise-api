package com.bookwise_api.service;

import com.bookwise_api.domain.Book.Book;
import com.bookwise_api.domain.Book.BookCreateDTO;
import com.bookwise_api.domain.Book.BookPageDTO;
import com.bookwise_api.domain.Book.BookResponseDTO;
import com.bookwise_api.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Transactional
    public ResponseEntity createBook(BookCreateDTO bookData, UriComponentsBuilder uriBuilder) {
        var book = new Book(bookData);
        repository.save(book);

        var uri = uriBuilder.path("/books/{id}").buildAndExpand(book.getId()).toUri();
        return ResponseEntity.created(uri).body("Book registered with success!");
    }

    public ResponseEntity<BookPageDTO> listBooks(Pageable pagination) {
        var page = repository.findAll(pagination)
                .map(BookResponseDTO::new); //paginaçao ja devolve um page do dto, sem precisar do stream

        var response = new BookPageDTO(
                page.getContent(),
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.isFirst(),
                page.isLast()
        );

        return ResponseEntity.ok(response);
    }

    public ResponseEntity<BookResponseDTO> findBookById(Long id) throws EntityNotFoundException {

        Book book = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Any book found with id: " + id));

        BookResponseDTO response = new BookResponseDTO(book);

        return ResponseEntity.ok(response);

    }
}
