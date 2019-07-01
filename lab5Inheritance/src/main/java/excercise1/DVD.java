package excercise1;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("dvd")
public class DVD extends Product {
    private String genre;

    public DVD(String de, String n, String g) {
        super(de, n);
        this.genre=g;
    }
}
