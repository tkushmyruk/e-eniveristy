package ua.taras.kushmyruk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.taras.kushmyruk.model.Discipline;

public interface DisciplineRepository  extends JpaRepository<Discipline, String> {
    Discipline findByDisciplineName(String disciplineName);
}
