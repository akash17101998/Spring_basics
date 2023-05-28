package com.example.spring.demo.service;

import com.example.spring.demo.models.Books;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
//            return book;
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("No such book id");
        }
        return book;
    }
}
