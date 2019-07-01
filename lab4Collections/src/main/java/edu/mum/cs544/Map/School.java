package edu.mum.cs544.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String schoolName;

    public School(String schoolName) {
        this.schoolName = schoolName;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="School_id")
    @MapKeyColumn(name="name")
    private Map<Integer, Student> students = new HashMap<>();
    public void addStudent(Student s){
        students.put(s.getStudentId(),s);
    }



}
