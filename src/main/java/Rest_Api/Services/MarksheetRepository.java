package Rest_Api.Services;

import Rest_Api.Entities.Marksheet;
import Rest_Api.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarksheetRepository extends JpaRepository<Marksheet,Integer> {
    public Marksheet findByStudent(Student student);
    public void deleteByStudent(Student student);
}
