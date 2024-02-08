package Rest_Api.Entities;

public class CourseRequest {
    private Courses courses;
    private Teachers teachers;

    public CourseRequest(Courses courses, Teachers teachers) {
        this.courses = courses;
        this.teachers = teachers;
    }

    public CourseRequest() {
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    public Teachers getTeachers() {
        return teachers;
    }

    public void setTeachers(Teachers teachers) {
        this.teachers = teachers;
    }
}
