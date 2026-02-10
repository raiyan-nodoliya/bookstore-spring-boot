package com.learning.BookStore.Reposiptory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.BookStore.Entity.MyBookList;


@Repository
public interface MyBookRepository extends JpaRepository<MyBookList, Integer> {
	
}
