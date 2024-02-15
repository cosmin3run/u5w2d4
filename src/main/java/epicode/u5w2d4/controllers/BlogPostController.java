package epicode.u5w2d4.controllers;

import epicode.u5w2d4.entities.BlogPost;
import epicode.u5w2d4.payloads.NewBlogPostPayload;
import epicode.u5w2d4.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/blogPost")

public class BlogPostController {
    @Autowired
    BlogPostService blogPostService;

    //Get All BlogPosts
    @GetMapping
    public Page<BlogPost> getAllBlogposts(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int size,
                                          @RequestParam(defaultValue = "id") String orderBy
    )
    {
        return this.blogPostService.getBlogPosts(page, size, orderBy);
    }

    //Get BlogPost By ID
    @GetMapping("/{id}")
    public BlogPost findById(@PathVariable UUID id) {
        return this.blogPostService.findById(id);
    }

    //Save BlogPost
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost saveBlogPost(@RequestBody NewBlogPostPayload newBlogPost) {return this.blogPostService.saveBlogPost(newBlogPost);}

    @PutMapping("/{id}")
    public BlogPost findByAndUpdate(@PathVariable UUID id, @RequestBody NewBlogPostPayload updatedBlogPost){
        return this.blogPostService.findByIdAndUpdate(id, updatedBlogPost);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable UUID id) {this.blogPostService.findByIdAndDelete(id);}
}

