package com.inno.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inno.bean.Books;
import com.inno.repository.BooksRepository;

/*
 * purpose of class to perform business logic on books.
 */
@Service
public class BooksService {

	@Autowired
	public BooksRepository booksRepository;

	/*
	 * this method is used for getting all books record.
	 */
	public List<Books> getAllBooks() {
		List<Books> books = new ArrayList<Books>();
		booksRepository.findAll().forEach(books1 -> books.add(books1));
		return books;

	}

	/*
	 * this method is used for getting book record by id.
	 */
	public Books getBookSById(int id) {
		return booksRepository.findById(id).get();

	}

	/*
	 * this method is used for save/update book record.
	 */
	public void saveOrUpdate(Books book) {
		booksRepository.save(book);
	}

	/*
	 * this method is used for delete book record by id.
	 */
	public void deleteBookById(int id) {
		booksRepository.deleteById(id);
	}

	/*
	 * this method is used for update book record by id.
	 */
	public void updateBook(Books book, int bookId) {
		booksRepository.save(book);
	}
	/*
	 * this method is used for getting book by author name.
	 */
	public List<Books> getBookByAuthorName(String name){
		return booksRepository.findByAuthorContaining(name);
	}

}
