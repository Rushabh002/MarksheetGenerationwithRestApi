package Rest_Api.Controller;

import Rest_Api.Entities.*;
import Rest_Api.Services.CourseRepository;
import Rest_Api.Services.MarksheetRepository;
import Rest_Api.Services.StudentRepository;

import Rest_Api.Services.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class FormController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    MarksheetRepository marksheetRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    TeacherRepository teacherRepository;

    @PostMapping("/add")
    public void addStudDetails(@RequestBody StudentRequest studentRequest) {
        Student student = studentRequest.getStudent();
        Marksheet marksheet = studentRequest.getMarksheet();
        marksheet.setStudent(student);
        marksheetRepository.save(marksheet);
//        studentRepository.save(student);
    }

    @PostMapping("/addcourseandteacher")
    public void addCourseAndTeacher(@RequestBody CourseRequest courseRequest) {
        Courses courses = courseRequest.getCourses();
        Teachers teachers = courseRequest.getTeachers();
        teachers.setCourses(courses);
        courseRepository.save(courses);
        teacherRepository.save(teachers);
    }
    @GetMapping("/viewCoursesAndTeachers")
    public ResponseEntity<List<Teachers>> getTeacher() {

        return new ResponseEntity<>(teacherRepository.findAll(), HttpStatus.OK);
    }
    @PutMapping("/updatestudent/{id}")
    public void updatestuden(@PathVariable int id,@RequestBody Student s){

        Student student= studentRepository.findById(id).get();
        student.setName(s.getName());
        student.setAge(s.getAge());
        student.setCls(s.getCls());
        studentRepository.save(student);
    }

    @PutMapping("/updatemarksheet/{id}")
    public void updateMarksheet(@PathVariable int id,@RequestBody Marksheet m){
        Student student=studentRepository.findById(id).get();
        Marksheet marksheet = marksheetRepository.findByStudent(student);
        marksheet.setPhysics(m.getPhysics());
        marksheet.setChemistry(m.getChemistry());
        marksheet.setMaths(m.getMaths());
        marksheet.setEnglish(m.getEnglish());

        marksheetRepository.save(marksheet);
    }
    @GetMapping("/viewstudent/{id}")
    public Student viewstudent(@PathVariable int id){
       Student student =studentRepository.findById(id).get();
    return student;
    }

    @GetMapping("/viewmarksheet/{id}")
    public Marksheet viewmarksheet(@PathVariable int id){
        Student student =studentRepository.findById(id).get();
        Marksheet marksheet=marksheetRepository.findByStudent(student);

        return marksheet;
    }
    @GetMapping("/viewall")
    public ResponseEntity<List<Student>> getStudent() {
        System.out.println(studentRepository.findAll());
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/viewmall")
    public List<Marksheet> getmarksheets() {

        return marksheetRepository.findAll();
    }
    @DeleteMapping("/deletestudent/{id}")
    @Transactional
    public void deletestudent(@PathVariable int id){
        Student student = studentRepository.findById(id).get();
        marksheetRepository.deleteByStudent(student);
        studentRepository.deleteById(id);
    }


}
