package group.modulelibrary.service.api;

import group.modulelibrary.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    boolean saveBook(Book book);
    boolean deleteBook(Book book);
    Book getBookById(Integer id);
}
