package manytooneuniuni;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
//@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String ISBN;

    public Book(String title, String isbn, Publisher p){
        this.publisher=p;
        this.ISBN=isbn;
        this.title=title;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "Book_Publisher")
    private Publisher publisher;


}
