package manytooneuniuni;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
@Data
@NoArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fName;
    @Column(nullable = false)
    private String lName;


    public Publisher(String fn, String ln) {
        this.fName= fn;
        this.lName=ln;
    }
}
