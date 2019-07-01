package onetomanybi;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
@Data
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String name;

    @OneToMany(mappedBy = "dept", cascade = CascadeType.ALL)
    private List<Employee> employees= new ArrayList<Employee>();

    public Department (String city, String name){
        this.city=city;
        this.name=name;
    }

    public void addEmployee(Employee e) {
        employees.add(e);


    }
}
