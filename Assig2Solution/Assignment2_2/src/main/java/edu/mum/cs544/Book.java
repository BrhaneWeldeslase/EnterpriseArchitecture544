package edu.mum.cs544;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString

@Entity()
public class Book {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String ISBN;
    private String author;
    private double price;
    //@Temporal(TemporalType.DATE)
    //private localDate publish_date;
    private java.util.Date publish_date;

   public Book(){

    }

    public Book(String title, String ISBN, String author, double price){
                //Date published_date) {
        this.title=title;
        this.ISBN = ISBN;
        this.author = author;
        this.price = price;
        //this.publish_date = published_date;
    }




}

