package Rest_Api.Services;

import Rest_Api.Entities.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teachers,Integer> {
}
