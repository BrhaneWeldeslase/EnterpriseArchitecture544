package manytoonebi;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fName;
    private String lName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "Emp_Office")
    private Office office;

    public Employee(String fName,String lName) {
        this.lName = lName;
        this.fName= fName;
    }
}
