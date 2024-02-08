package Rest_Api.Entities;

import jakarta.persistence.*;

@Entity
public class Teachers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int teacherId;
    private String teacherName;
    @OneToOne
    @JoinColumn(name = "course_id")
    private Courses courses;

    public Teachers(int teacherId, String teacherName, Courses courses) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.courses = courses;
    }

    public Teachers() {
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Teachers{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", courses=" + courses +
                '}';
    }
}
