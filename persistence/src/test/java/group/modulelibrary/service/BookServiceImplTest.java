package group.modulelibrary.service;

import com.sun.glass.ui.Application;
import group.modulelibrary.model.Author;
import group.modulelibrary.model.Book;
import group.modulelibrary.repository.BookRepository;
import group.modulelibrary.service.api.BookService;
import group.modulelibrary.service.impl.BookServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.Classes;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BookServiceImplTest {

    private BookService bookService;

    /*@Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }*/

    public static Book createBookForTest() {
        Book book = new Book();
        book.setBookId(56);
        book.setTitle("Стажировка");
        book.setGenre("Приключения");
        book.setEdition("Симбирсофт");
        book.setEditionYear("2019");
        Author author = new Author();
        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        author.setAuthorId(29);
        author.setFirstName("Иван");
        author.setLastName("Николаев");
        author.setPatronymic("хз");
        author.setBooks(bookList);
        book.setAuthor(author);
        return book;
    }

    @Test
    public void getAllBooks() {
    }

    @Test
    public void saveBook() {
        Book book = createBookForTest();
        Assert.assertNotNull(book);
        boolean isBookCreated = bookService.saveBook(book);
        System.out.println(isBookCreated);
        System.out.println(book.getBookId());
        //Assert.assertTrue(isBookCreated);
        //Assert.assertEquals();
    }

    @Test
    public void deleteBook() {
    }

    @Test
    public void getBookById() {
    }
}