package onetomanyuni;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String place;
    @Temporal(TemporalType.DATE)
    private Date time;

    public Reservation(String place, Date time){
        this.place=place;
        this.time=time;
    }
}
