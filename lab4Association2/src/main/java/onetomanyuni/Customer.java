package onetomanyuni;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fName;
    private String lName;

    public Customer(String f, String l){
        this.fName=f;
        this.lName=l;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Reservation> reservation= new ArrayList<Reservation>();


}
