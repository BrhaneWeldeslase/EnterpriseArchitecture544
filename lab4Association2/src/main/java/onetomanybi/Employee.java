package onetomanybi;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Entity
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fname;
    private String lname;

    @ManyToOne
    @JoinTable(name="Dep_Emp")
    private Department dept;

    public Employee(String fname, String lname){
        this.fname=fname;
        this.lname=lname;
    }

}
