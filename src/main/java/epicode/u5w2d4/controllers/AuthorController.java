package epicode.u5w2d4.controllers;


import epicode.u5w2d4.entities.Author;
import epicode.u5w2d4.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping
    public List<Author> getAuthors() {return this.authorService.getAuthors();}

    @GetMapping("/{id}")
    public Author findById(@PathVariable UUID id){return this.authorService.findById(id);}


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthor(@RequestBody Author newAuthor) {return this.authorService.saveAuthor(newAuthor);}


    @PutMapping("/{id}")
    public Author findByIdAndUpdate(@PathVariable UUID id, @RequestBody Author updatedAuthor){
        return this.authorService.findByIdAndUpdate(id,updatedAuthor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable UUID id) {this.authorService.findByIdAndDelete(id);}
}

