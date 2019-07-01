package edu.mum.cs544.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Student {

    @Id
    @Column(name="Student_id")
    private Integer studentId;
    private String fName;
    private String lName;

    public Student(Integer studentId) {
        this.studentId = studentId;
    }
}
