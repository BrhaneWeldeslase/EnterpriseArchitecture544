package edu.mum.cs544.oneToManyBiDepartmentEmployee;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Setter
@Getter
@ToString
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    @OneToMany(mappedBy = "department" , cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList();

    public Department(){}

    public Department(String name, String location){
        this.name= name;
        this.location = location;

    }

    public void addEmployee(Employee employee){

        employees.add(employee);
        employee.setDepartment(this);


    }

}
