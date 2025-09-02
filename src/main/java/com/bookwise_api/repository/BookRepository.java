package com.bookwise_api.repository;

import com.bookwise_api.domain.Book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
