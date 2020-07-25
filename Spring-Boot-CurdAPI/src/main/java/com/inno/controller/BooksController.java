package com.inno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inno.bean.Books;
import com.inno.service.BooksService;

/**
 * this class is used to handle Http request from end user.
 */
@RestController
@CrossOrigin(origins = "*")
public class BooksController {

	/**
	 * Dependency Injection
	 */
	@Autowired
	public BooksService booksService;

	@GetMapping("/allbook")
	private List<Books> getAllBooks() {
		return booksService.getAllBooks();
	}

	@GetMapping("/book/{bookId}")
	private Books getBookById(@PathVariable("bookId") int bookId) {
		return booksService.getBookSById(bookId);
	}

	@DeleteMapping("/book/{bookId}")
	private String deleteBookById(@PathVariable("bookId") int bookId) {
		booksService.deleteBookById(bookId);
		return "Book is deleted with book-id: "+bookId;
	}

	@PostMapping("/book")
	private String saveBook(@RequestBody Books books) {
		booksService.saveOrUpdate(books);
		int id = books.getBookId();
		return "Book save with book-id: " + id;
	}

	@PutMapping("/book")
	private Books createOrUpdateBook(@RequestBody Books books) {
		booksService.saveOrUpdate(books);
		return books;

	}
	
	@GetMapping("/book/author/{name}")
	private List<Books> fetchBookByAuthorName(@PathVariable("name") String name){
		return booksService.getBookByAuthorName(name);
	}
	
}