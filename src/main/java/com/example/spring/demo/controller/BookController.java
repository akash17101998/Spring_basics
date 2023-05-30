package com.example.spring.demo.controller;

import com.example.spring.demo.models.Books;
import com.example.spring.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@Controller // but agar hum yaha restController lga lete h to responsebody lgane ki need ni hoti
@RestController
public class BookController{
    @Autowired
    private BookService bookService;
//    @RequestMapping(value = "/books",method = RequestMethod.GET)   // define method and url value
//    @ResponseBody          // this will return the string as it is
    @GetMapping("/books")
    public ResponseEntity<List<Books>> getBooks(){
        List<Books> list = this.bookService.getAllBooks();
        if (list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Books> getBookId(@PathVariable("id") int id){
        Books books = this.bookService.getBookById(id);
        if (books==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(books));
    }

    @PostMapping("/books")
    public ResponseEntity<Books> addBook(@RequestBody Books books){
        Books b= null;
        try {
            b =this.bookService.addBook(books);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(b);
        }
    }

    // delete by id
    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId){
      try {
          this.bookService.deleteBook(bookId);
          return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
      }catch (Exception e){
          e.printStackTrace();
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
    }

    // update
    @PutMapping("/books/{id}")
    public ResponseEntity<Books> updateBook(@RequestBody Books books,@PathVariable("id") int id){
        try {
            this.bookService.updateBook(books,id);
            return ResponseEntity.ok().body(books);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
     }
}
