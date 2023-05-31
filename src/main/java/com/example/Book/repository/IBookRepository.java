package com.example.Book.repository;

import  com.example.Book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {
}
