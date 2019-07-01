package excercise1;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("book")
public class Book extends Product {
    private String title;

    public Book(String de, String n, String t) {
        super(de, n);
        this.title=t;
    }
}
