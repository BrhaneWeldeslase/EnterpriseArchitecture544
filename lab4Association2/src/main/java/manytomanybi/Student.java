package manytomanybi;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

//@Entity
@Data
@NoArgsConstructor
public class Student {
    @Id
    private Integer studentid;

    private String fName;
    private String lName;

    @ManyToMany(mappedBy = "students")

    private List<Course> courses= new ArrayList<Course>();

    public Student(Integer id, String fn, String ln){
        this.studentid=id;
        this.fName=fn;
        this.lName=ln;
    }

}
