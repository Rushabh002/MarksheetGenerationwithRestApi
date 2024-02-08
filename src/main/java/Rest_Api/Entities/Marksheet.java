package Rest_Api.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

public class Marksheet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int mid;
    private int physics;
    private int chemistry;
    private int maths;
    private int english;
    @OneToOne(cascade =CascadeType.ALL )
    @JoinColumn(name = "student_id")
    private Student student;

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getPhysics() {
        return physics;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }

    public int getChemistry() {
        return chemistry;
    }

    public void setChemistry(int chemistry) {
        this.chemistry = chemistry;
    }

    public int getMaths() {
        return maths;
    }

    public void setMaths(int maths) {
        this.maths = maths;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Marksheet(int mid, int physics, int chemistry, int maths, int english, Student student) {
        this.mid = mid;
        this.physics = physics;
        this.chemistry = chemistry;
        this.maths = maths;
        this.english = english;
        this.student = student;
    }

    public Marksheet() {
    }
}
