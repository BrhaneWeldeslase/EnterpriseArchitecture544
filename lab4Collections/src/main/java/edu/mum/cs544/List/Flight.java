package edu.mum.cs544.List;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Getter
@Setter
@ToString
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    @Column(name="DepartedFrom")
    private String from;
    @Column(name="ArriveTo")
    private String to;
//    private Passenger passengers ;
    @OneToMany
    private List<Passenger> passengers = new ArrayList();

    public Flight(){}

    public Flight(String number, String from, String to, List<Passenger> passengers){
        this.number = number;
        this.from = from;
        this.to = to;
        this.passengers = passengers;

    }

}
