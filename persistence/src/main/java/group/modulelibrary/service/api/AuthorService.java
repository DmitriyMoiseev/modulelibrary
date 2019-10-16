package group.modulelibrary.service.api;

import group.modulelibrary.model.Author;
import group.modulelibrary.model.Book;
import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();
    void saveAuthor(Author author);
    void deleteAuthor(Author author);
    Author getAuthorById(Integer id);
    List<Book> getBooks(Author author);
}
