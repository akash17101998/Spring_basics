package com.example.spring.demo.dao;

import com.example.spring.demo.models.Books;
import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Books, Integer>{
    public Books findById(int id);
}
