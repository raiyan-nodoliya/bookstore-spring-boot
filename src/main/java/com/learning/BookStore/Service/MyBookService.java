package com.learning.BookStore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.BookStore.Entity.MyBookList;
import com.learning.BookStore.Reposiptory.BookRepository;
import com.learning.BookStore.Reposiptory.MyBookRepository;

@Service
public class MyBookService {

  
	
	@Autowired
	private MyBookRepository myBookRepository;

   
	
	public void saveMyBooks(MyBookList myBookList) {
		myBookRepository.save(myBookList);
	}
	
	public List<MyBookList> getAllMyBooks() {
		return myBookRepository.findAll();
	}
	
	
	public void deletebyId(int id) {
		myBookRepository.deleteById(id);
	}

}
