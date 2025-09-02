package com.bookwise_api.repository;

import com.bookwise_api.domain.Book.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findAllByActiveTrue(Pageable pageable);
    Optional<Book> findByIdAndActiveTrue(Long id);
}
