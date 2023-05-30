package com.example.spring.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Author{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int authorId;
    private String fname;
    private String lname;
    @OneToOne(mappedBy = "author")   //not create extra field
    @JsonBackReference         // to avoid the infinite loop and not covert the field in json so not show data in postman
    private Books books;

    @Override
    public String toString(){
        return "Author{" +
                "authorId=" + authorId +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }

    public int getAuthorId(){
        return authorId;
    }

    public void setAuthorId(int authorId){
        this.authorId = authorId;
    }

    public String getFname(){
        return fname;
    }

    public void setFname(String fname){
        this.fname = fname;
    }

    public String getLname(){
        return lname;
    }

    public void setLname(String lname){
        this.lname = lname;
    }
}
