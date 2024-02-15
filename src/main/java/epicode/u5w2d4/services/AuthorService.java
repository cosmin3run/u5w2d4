package epicode.u5w2d4.services;

import epicode.u5w2d4.DAO.AuthorDAO;
import epicode.u5w2d4.entities.Author;
import epicode.u5w2d4.exceptions.BadRequestException;
import epicode.u5w2d4.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorService {
    @Autowired
    private AuthorDAO authorsDAO;



    public List<Author> getAuthors() {return this.authorsDAO.findAll();}

    public Author saveAuthor(Author newAuthor) {

        if(this.authorsDAO.existsByEmail(newAuthor.getEmail())){
            throw new BadRequestException("Author with email " + newAuthor.getEmail() + " already exists");
        } else {
            newAuthor.setAvatar("https://ui-avatars.com/api/?name=" + newAuthor.getName().charAt(0) + "+" + newAuthor.getSurname().charAt(0));
            authorsDAO.save(newAuthor);
            return newAuthor;
        }
    }

    public Author findById(UUID id) {
        return authorsDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Author findByIdAndUpdate(UUID id, Author updatedAuthor){
        Author found = this.findById(id);

        found.setName(updatedAuthor.getName());
        found.setSurname(updatedAuthor.getSurname());
        found.setEmail(updatedAuthor.getEmail());
        found.setDateBirth(updatedAuthor.getDateBirth());
        found.setAvatar(updatedAuthor.getAvatar());
        return authorsDAO.save(found);
    }

    public void findByIdAndDelete(UUID id){
        Author found = this.findById(id);
        authorsDAO.delete(found);
    }

}