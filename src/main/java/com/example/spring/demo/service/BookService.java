package com.example.spring.demo.service;

import com.example.spring.demo.models.Books;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService{
    private static List<Books> list = new ArrayList<>();
    static {
        list.add(new Books(2,"python","guido"));
        list.add(new Books(3,"django","rummy"));
        list.add(new Books(4,"spring","dummy"));
    }

    // get all books
    public List<Books> getAllBooks(){
        return list;
    }

    // get book by id
    public Books getBookById(int id){
        Books book = null;
        try {
            book = list.stream().filter(e->e.getId()==id).findFirst().get();
        }catch (Exception e){
//            System.out.println(e.getMessage());
            System.out.println("No such book id");
        }
        return book;
    }

    // add book
    public Books addBook(Books b){
        list.add(b);
        return b;
    }

    public void deleteBook(int id){
        try {
            list = list.stream().filter(books -> books.getId() != id).
                    collect(Collectors.toList());
        }catch (Exception e){
            System.out.println("No such book");
        }
    }


    public Books updateBook(Books books,int id){
        list.stream().map(b->{   // map is used to some operation in a list
            if (b.getId()==id){
                b.setTitle(books.getTitle());
                b.setAuthor(books.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
        return books;
    }
}
