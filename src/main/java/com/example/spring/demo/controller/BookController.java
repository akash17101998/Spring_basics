package com.example.spring.demo.controller;

import com.example.spring.demo.models.Books;
import com.example.spring.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller // but agar hum yaha restController lga lete h to responsebody lgane ki need ni hoti
@RestController
public class BookController{
    @Autowired
    private BookService bookService;
//    @RequestMapping(value = "/books",method = RequestMethod.GET)   // define method and url value
//    @ResponseBody          // this will return the string as it is
    @GetMapping("/books")
    public List<Books> getBooks(){
//        Books books = new Books();
//        books.setId(1);
//        books.setTitle("java");
//        books.setAuthor("Xyz");

        return this.bookService.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public Books getBookId(@PathVariable("id") int id){
        return this.bookService.getBookById(id);
    }

    @PostMapping("/books")
    public Books addBook(@RequestBody Books books){
        this.bookService.addBook(books);
        return books;
    }
}
