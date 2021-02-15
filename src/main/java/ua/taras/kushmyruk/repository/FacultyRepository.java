package ua.taras.kushmyruk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.taras.kushmyruk.model.Faculty;

@Repository
public interface FacultyRepository  extends JpaRepository<Faculty, String> {
    Faculty findByFacultyName(String facultyName);
}
