package manytomanybi;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
@Data
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String couseName;
    private int credit;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private List<Student> students= new ArrayList<Student>();

    public Course(String cName, int cr){
        this.couseName=cName;
        this.credit= cr;
    }

    public void addStudent(Student st){
        students.add(st);
        st.getCourses().add(this);
    }

}
