package hanu.english.repository;

import hanu.english.entity.User;
import jakarta.validation.constraints.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findByName(Pageable pageable, String name);

    User findByEmail(String email);

    Optional<User> findByName(String name);

    boolean existsByName(String name);
}
