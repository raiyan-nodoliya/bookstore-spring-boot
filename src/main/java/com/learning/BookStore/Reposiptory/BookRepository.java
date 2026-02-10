package com.learning.BookStore.Reposiptory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.BookStore.Entity.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
