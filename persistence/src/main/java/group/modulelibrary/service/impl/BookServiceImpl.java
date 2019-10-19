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
@Transactional
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
        Optional<Book> bookCandidate = bookRepository.findBookByTitle(book.getTitle());
        if(bookCandidate.isPresent()) {
            return false;
        } else {
            bookRepository.save(book);
            return true;
        }
    }

    @Override
    public boolean deleteBook(Book book) {
        Optional<Book> bookCandidate = bookRepository.findById(book.getBookId());
        if(bookCandidate.isPresent()) {
            bookRepository.delete(book);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Book getBookById(Integer id) {
        return bookRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
