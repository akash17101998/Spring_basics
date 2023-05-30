package com.example.spring.demo.service;

import com.example.spring.demo.dao.BookRepository;
import com.example.spring.demo.models.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService{

    @Autowired
    private BookRepository bookRepository;

    // get all books
    public List<Books> getAllBooks(){
        List<Books> list= (List<Books>) this.bookRepository.findAll();
        return list;
    }

    // get book by id
    public Books getBookById(int id){
        Books book = null;
        try {
//            book = list.stream().filter(e->e.getId()==id).findFirst().get();
            book = this.bookRepository.findById(id);
        }catch (Exception e){
//            System.out.println(e.getMessage());
            System.out.println("No such book id");
        }
        return book;
    }

    // add book
    public Books addBook(Books b){
        Books result = this.bookRepository.save(b);
        return result;
    }

    public void deleteBook(int id){
        try {
            bookRepository.deleteById(id);
        }catch (Exception e){
            System.out.println("No such book");
        }
    }


    public void updateBook(Books books,int id){
        books.setId(id);
        bookRepository.save(books);
    }
}
