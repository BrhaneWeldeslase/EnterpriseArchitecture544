package excercise1;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cd")
public class CD extends Product {
    private String artist;

    public CD(String de, String n, String a) {
        super(de, n);
        this.artist=a;
    }
}

