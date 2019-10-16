package group.modulelibrary.service.impl;

import group.modulelibrary.model.Book;
import group.modulelibrary.repository.BookRepository;
import group.modulelibrary.service.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl (BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public boolean saveBook(Book book) {
        Optional<Book> bookCandidate = bookRepository.findById(book.getBookId());
        /*if(bookCandidate.isPresent()) {
            return true;
        } else {
            bookRepository.save(book);
            return true;
        }*/
        return false;
    }

    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public Book getBookById(Integer id) {
        return bookRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
