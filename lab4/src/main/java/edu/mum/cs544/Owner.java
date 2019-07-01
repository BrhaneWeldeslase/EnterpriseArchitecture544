package edu.mum.cs544;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Getter
@Setter
@ToString
@Entity
public class Owner {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String address;

    public Owner(){}

    public Owner(String name, String address){
        this.name = name;
        this.address = address;
    }


}
