package group.modulelibrary;

import group.modulelibrary.model.Author;
import group.modulelibrary.model.Book;
import group.modulelibrary.service.api.AuthorService;
import group.modulelibrary.service.impl.BookServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BookServiceTest {

    @Autowired
    private BookServiceImpl bookService;

    @Autowired
    private AuthorService authorService;

    public Book createBookForTest() {
        Book book = new Book();
        book.setTitle("Стажировка");
        book.setGenre("Приключения");
        book.setEdition("Симбирсофт");
        book.setEditionYear("2019");
        Author author = new Author();
        author.setFirstName("Иван");
        author.setLastName("Николаев");
        author.setPatronymic("хз");
        book.setAuthor(author);
        authorService.saveAuthor(author);
        bookService.saveBook(book);
        return book;
    }

    public void saveBook(String title) {
        Book createdBook = createBookForTest();
        Book book = new Book();
        book.setTitle(title);
        book.setGenre("Приключения");
        book.setEdition("Симбирсофт");
        book.setEditionYear("2019");
        book.setAuthor(createdBook.getAuthor());
        Assert.assertTrue(bookService.saveBook(book));
    }

    @Test
    public void saveBookPositiveTest () {
        saveBook("Мучение");
    }

    @Test
    public void saveBookNegativeTest () {
        saveBook("Стажировка");
    }

    @Test
    public void getBookByIdTest() {
        Book createdBook = createBookForTest();
        Book receivedBook = bookService.getBookById(createdBook.getBookId());
        Assert.assertEquals(createdBook, receivedBook);
    }

    @Test
    public void getBookListTest() {
        Book createdBook = createBookForTest();
        Book book = new Book();
        book.setTitle("Хаос");
        book.setGenre("Приключения");
        book.setEdition("Симбирсофт");
        book.setEditionYear("2019");
        book.setAuthor(createdBook.getAuthor());
        bookService.saveBook(book);
        List<Book> bookList = new ArrayList<>();
        bookList.add(createdBook);
        bookList.add(book);
        List<Book> receivedBookList = bookService.getAllBooks();
        Assert.assertEquals(bookList, receivedBookList);
    }

    @Test
    public void deleteBookTest() {
        Book createdBook = createBookForTest();
        Assert.assertTrue(bookService.deleteBook(createdBook));
    }
}
