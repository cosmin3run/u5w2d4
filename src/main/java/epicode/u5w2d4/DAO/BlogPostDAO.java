package epicode.u5w2d4.DAO;

import epicode.u5w2d4.entities.Author;
import epicode.u5w2d4.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BlogPostDAO extends JpaRepository<BlogPost, UUID> {
    List<BlogPost> findByAuthor(Author author);
}
