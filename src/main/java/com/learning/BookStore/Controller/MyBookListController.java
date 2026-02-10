package com.learning.BookStore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.learning.BookStore.Service.MyBookService;

@Controller
public class MyBookListController {
	
	@Autowired
	private MyBookService myBookService;
	
	@GetMapping("/deleteMyList/{id}")
	public String DeleteMyList(@PathVariable int id) {
		myBookService.deletebyId(id) ;
		return "redirect:/my_books";
	}

}
