package ua.taras.kushmyruk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.taras.kushmyruk.model.StudentOrder;

public interface StudentOrderRepository extends JpaRepository<StudentOrder, Long> {

    @Query("SELECT so FROM StudentOrder so INNER JOIN FETCH so.student s WHERE s.id = id ")
    StudentOrder findByStudentId(@Param("id") Long id);
}
