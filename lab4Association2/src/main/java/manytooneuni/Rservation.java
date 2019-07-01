package manytooneuni;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity

@Data
@NoArgsConstructor
public class Rservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libName;
    @Temporal(TemporalType.DATE)
    private Date time;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="reser_book")
    private Book book;

    public Rservation(String name, Date time, Book b){
        this.libName=name;
        this.time=time;
        this.book=b;
    }

}
