package excercise1;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class OrderLine {
    @Id
    @GeneratedValue
    private Long id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name="OrdLine_Prod")
    private Product product;

    public OrderLine(int qn, Product p){
        this.quantity=qn;
        this.product=p;
    }
}
