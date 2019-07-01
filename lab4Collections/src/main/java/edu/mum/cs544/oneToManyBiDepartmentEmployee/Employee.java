package edu.mum.cs544.oneToManyBiDepartmentEmployee;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "newEmployee")
@Getter
@Setter
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;

    public Employee(){}

    public Employee(String name){
        this.name = name;
        //this.department = department;

    }

//    public void addLaptop(Laptop laptop){
//        department.add(laptop);
//        laptop.setEmp1(this);
//
//    }



}
