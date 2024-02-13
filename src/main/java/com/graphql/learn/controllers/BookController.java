package com.graphql.learn.controllers;


import com.graphql.learn.entities.Book;
import com.graphql.learn.services.BookService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/books")
@Controller
public class BookController {

    @Autowired
    private BookService bookService;
//    @PostMapping
    @MutationMapping("createBook")
    public Book Create(@Argument BookInput book) {
        Book b = new Book();
        b.setTitle(book.getTitle());
        b.setDesc(book.getDesc());
        b.setAuthor(book.getAuthor());
        b.setPrice(book.getPrice());
        b.setPages(book.getPages());
        return bookService.create(b);
    }
//    @GetMapping
    @QueryMapping("allBooks")
    public List<Book> getAll() {
        return this.bookService.getAll();
    }
//    @GetMapping("/{bookId}")
    @QueryMapping("getBooks")
    public Book get(@Argument int bookId){
        return this.bookService.get(bookId);
    }

}
@Data
class BookInput{
    private String title;
    private String desc;
    private String author;
    private double price;
    private int pages;
}
