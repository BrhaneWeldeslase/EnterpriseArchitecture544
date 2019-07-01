import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@SecondaryTables(
        @SecondaryTable(name="Address", pkJoinColumns= {
                @PrimaryKeyJoinColumn(name="PATIENT_ID", referencedColumnName="id")
        })
)
@SecondaryTable(name = "Address")
public class Patient {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(table = "Address")
    private String street;

    @Column(table = "Address")
    private String zip;

    @Column(table = "Address")
    private String city;



    public Patient(String name, String street, String zip, String city) {
        this.name = name;
        this.street = street;
        this.zip = zip;
        this.city = city;
    }
}
