package com.graphql.learn;

import com.graphql.learn.entities.Book;
import com.graphql.learn.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphqlProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlProjectApplication.class, args);
	}

	@Autowired
	private BookService bookService;
	@Override
	public void run(String... args) throws Exception {

		Book b1 = new Book();
		b1.setTitle("Complete reference");
		b1.setDesc("for learning java");
		b1.setPages(200);
		b1.setPrice(5000);
		b1.setAuthor("ashish");

		Book b2 = new Book();
		b2.setTitle("spider");
		b2.setDesc("The book of spider");
		b2.setPages(300);
		b2.setPrice(2000);
		b2.setAuthor("kush");

		Book b3 = new Book();
		b3.setTitle("time");
		b3.setDesc("The book of time");
		b3.setPages(500);
		b3.setPrice(1000);
		b3.setAuthor("jay");

		this.bookService.create(b1);
		this.bookService.create(b2);
		this.bookService.create(b3);


	}
}
