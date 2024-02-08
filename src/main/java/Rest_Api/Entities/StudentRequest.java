package Rest_Api.Entities;

public class StudentRequest {

    private Student student;
    private Marksheet marksheet;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Marksheet getMarksheet() {
        return marksheet;
    }

    public void setMarksheet(Marksheet marksheet) {
        this.marksheet = marksheet;
    }
}

