package epicode.u5w2d4.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Setter
@Getter
@ToString
@NoArgsConstructor

@Entity
@Table(name = "blog_post")
public class BlogPost {
    @Id
    @GeneratedValue
    private UUID id;
    private String category;
    private String title;
    private String cover;
    private String content;

    @Column(name = "read_time")
    private int readTime;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private Author author;






    public BlogPost(String category, String title, String cover, String content, int readTime) {
        this.category = category;
        this.title = title;
        this.cover = cover;
        this.content = content;
        this.readTime = readTime;
    }
}
