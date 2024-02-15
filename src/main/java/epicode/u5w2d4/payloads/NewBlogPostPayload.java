package epicode.u5w2d4.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class NewBlogPostPayload {
    private UUID authorId;

    @NotEmpty(message = "Category is mandatory")
    private String category;

    @NotEmpty(message = "Content is mandatory")
    private String content;
    private int readTime;
    private String cover;
    @NotEmpty(message = "Name is mandatory")
    @NotBlank(message = "You should write something")
    private String title;
}
