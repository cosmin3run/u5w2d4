package epicode.u5w2d4.DAO;

import epicode.u5w2d4.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorDAO extends JpaRepository<Author, UUID> {
    boolean existsByEmail(String email);
}