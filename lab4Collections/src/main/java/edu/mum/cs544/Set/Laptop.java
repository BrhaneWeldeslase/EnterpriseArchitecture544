package edu.mum.cs544.Set;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String price;
    private String brand;
    @ManyToOne(cascade = CascadeType.ALL)
    private Employee emp1;

    public Laptop(){}

    public Laptop(String price, String brand){
        this.price= price;
        this.brand = brand;

    }

}
