package epicode.u5w2d4.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {super("The item you're searching for has not been found");}

    public NotFoundException(UUID id){super("Author with id: " + id + " doesn't exists");}
}