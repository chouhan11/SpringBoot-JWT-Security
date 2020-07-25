package com.inno.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "BOOK_TBL")
public class Books {

	@Id
	private int bookId;

	private String author;

	private String bookName;

	private int price;

}
