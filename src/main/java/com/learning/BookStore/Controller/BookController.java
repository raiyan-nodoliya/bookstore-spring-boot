package com.learning.BookStore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.learning.BookStore.Entity.Book;
import com.learning.BookStore.Entity.MyBookList;
import com.learning.BookStore.Service.BookService;
import com.learning.BookStore.Service.MyBookService;

import jakarta.validation.Valid;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private MyBookService myBookService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}

	@GetMapping("/available_book")
	public String getAllbook(Model model) {
		List<Book> list = bookService.getAllBook();
		model.addAttribute("books", list);
		return "bookList";
	}

	@PostMapping("/save")
	public String addBook( @ModelAttribute Book book,BindingResult result ) {
		
		 if (result.hasErrors()) {
		        
		        return "bookRegister";
		    }
		bookService.saveBook(book);
		return "redirect:/available_book";
	}

	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List<MyBookList> mb = myBookService.getAllMyBooks();
		model.addAttribute("mybooks", mb);
		return "myBooks";

	}

	@GetMapping("/mylist/{id}")
	public String getMyList(@PathVariable int id) {

	    Book book = bookService.getBookById(id);

	    MyBookList mb = new MyBookList(
	            book.getId(),
	            book.getName(),
	            book.getAuthor(),
	            book.getPrice()
	    );

	    myBookService.saveMyBooks(mb);

	    return "redirect:/my_books";
	}


	@GetMapping("/editBook/{id}")
	public String editBook(@PathVariable int id,Model model) {
		Book b=bookService.getBookById(id);
		model.addAttribute("book",b);
		
		return "bookEdit";
	}
	
	@GetMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable int id) {
		bookService.deleteById(id);
		return "redirect:/available_book";
	}

}
