package manytoonebi;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String address;

    public Office(String address) {
        this.address = address;
    }

    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<Employee>();

    public void addEmployee(Employee e){
        employees.add(e);
        e.setOffice(this);
    }


}
