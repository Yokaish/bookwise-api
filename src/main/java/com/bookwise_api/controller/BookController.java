package com.bookwise_api.controller;

import com.bookwise_api.domain.Book.BookCreateDTO;
import com.bookwise_api.domain.Book.BookPageDTO;
import com.bookwise_api.domain.Book.BookResponseDTO;
import com.bookwise_api.domain.Book.BookUpdateDataDTO;
import com.bookwise_api.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping
    public ResponseEntity createBook(@RequestBody @Valid BookCreateDTO bookData, UriComponentsBuilder uriBuilder) {

        return service.createBook(bookData, uriBuilder);

    }

    @GetMapping
    public ResponseEntity<BookPageDTO> listBooks(@PageableDefault(size = 10, sort = "title") Pageable pagination) {

        return service.listBooks(pagination);

    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> findBookById(@PathVariable Long id) {
        return service.findBookById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateBookData(@PathVariable Long id, @RequestBody BookUpdateDataDTO bookData) {
        return service.updateBookData(id, bookData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deactivateBook(@PathVariable Long id) {
        return service.deactivateBook(id);
    }


}
