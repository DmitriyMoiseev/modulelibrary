package group.modulelibrary.service.api;

import group.modulelibrary.model.Author;
import group.modulelibrary.model.Book;
import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();
    boolean saveAuthor(Author author);
    Author deleteAuthor(Author author);
    Author getAuthorById(Integer id);
}
