package excercise1;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="product_type",
        discriminatorType=DiscriminatorType.STRING)
public abstract class Product {
    @Id
    @GeneratedValue
    private Long id;

    private String descr;
    private String name;

    public Product(String de, String n){
        this.name=n;
        this.descr=de;
    }
}
