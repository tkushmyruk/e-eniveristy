package ua.taras.kushmyruk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.taras.kushmyruk.model.Student;

public interface StudentRepository  extends JpaRepository<Student, Long> {

}
