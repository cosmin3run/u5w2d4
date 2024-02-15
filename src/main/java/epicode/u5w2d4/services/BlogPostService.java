package epicode.u5w2d4.services;

import epicode.u5w2d4.DAO.BlogPostDAO;
import epicode.u5w2d4.entities.Author;
import epicode.u5w2d4.entities.BlogPost;
import epicode.u5w2d4.exceptions.NotFoundException;
import epicode.u5w2d4.payloads.NewBlogPostPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BlogPostService {

    @Autowired
    BlogPostDAO blogPostsDAO;

    @Autowired
    AuthorService authorService;


    public Page<BlogPost> getBlogPosts(int pageNumber, int size, String orderBy){
        if (size > 20) size = 20;
        Pageable pageable = PageRequest.of(pageNumber, size, Sort.by(orderBy));
        return blogPostsDAO.findAll(pageable);
    }

    public BlogPost saveBlogPost(NewBlogPostPayload newBlogPost){
        Author author = authorService.findById(newBlogPost.getAuthorId());
        BlogPost newPost = new BlogPost();
        newPost.setReadTime(newBlogPost.getReadTime());
        newPost.setTitle(newBlogPost.getTitle());
        newPost.setContent(newBlogPost.getContent());
        newPost.setCover(newBlogPost.getCover());
        newPost.setCategory(newBlogPost.getCategory());
        newPost.setAuthor(author);
        return blogPostsDAO.save(newPost);
    }

    public BlogPost findById(UUID id){
        return blogPostsDAO.findById(id).orElseThrow(NotFoundException::new);
    }



    public BlogPost findByIdAndUpdate(UUID id, NewBlogPostPayload updatedBlogPost) {
        BlogPost found = this.findById(id);
        found.setTitle(updatedBlogPost.getTitle());
        found.setCategory(updatedBlogPost.getCategory());
        found.setContent(updatedBlogPost.getContent());
        found.setCover(updatedBlogPost.getCover());
        found.setReadTime(updatedBlogPost.getReadTime());

        if(found.getAuthor().getId() != updatedBlogPost.getAuthorId()){
            Author newAuthor = authorService.findById(updatedBlogPost.getAuthorId());
            found.setAuthor(newAuthor);
        }

        return blogPostsDAO.save(found);
    }

    public void findByIdAndDelete(UUID id){
        BlogPost found = this.findById(id);
        blogPostsDAO.delete(found);
    }

    public List<BlogPost> findByAuthor(UUID id) {
        Author author = authorService.findById(id);
        return blogPostsDAO.findByAuthor(author);
    }

}