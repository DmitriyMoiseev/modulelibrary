package group.modulelibrary.service.api;

import group.modulelibrary.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    boolean saveBook(Book book);
    void deleteBook(Book book);
    Book getBookById(Integer id);
}
