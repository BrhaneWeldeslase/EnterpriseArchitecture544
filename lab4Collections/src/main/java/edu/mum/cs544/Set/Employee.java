package edu.mum.cs544.Set;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "emp1", cascade = CascadeType.ALL)
    private Set<Laptop> laptops = new HashSet<Laptop>();

    public Employee(){}
    public Employee(String name){
        this.name = name;

    }

    public void addLaptop(Laptop laptop){
        laptops.add(laptop);
        laptop.setEmp1(this);

    }



}
