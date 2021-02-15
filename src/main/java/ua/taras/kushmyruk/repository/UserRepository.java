package ua.taras.kushmyruk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.taras.kushmyruk.model.User;

public interface UserRepository  extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
