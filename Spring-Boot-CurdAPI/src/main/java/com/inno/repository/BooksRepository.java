package com.inno.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.inno.bean.Books;

/*
 * Repository that extends CurdRepo which provide inbuilt Methods
 */

public interface BooksRepository extends CrudRepository<Books, Integer> {
	
	//Derived Query Methods
	List<Books> findByAuthorContaining(String infix);

	 
	
}
