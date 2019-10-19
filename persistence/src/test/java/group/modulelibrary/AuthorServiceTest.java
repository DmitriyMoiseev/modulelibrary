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
public class AuthorServiceTest {

    @Autowired
    private BookServiceImpl bookService;

    @Autowired
    private AuthorService authorService;

    public Author createAuthorForTest() {
        /*Book book = new Book();
        book.setTitle("Стажировка");
        book.setGenre("Приключения");
        book.setEdition("Симбирсофт");
        book.setEditionYear("2019");*/
        Author author = new Author();
        author.setFirstName("Иван");
        author.setLastName("Николаев");
        author.setPatronymic("хз");
        /*List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        author.setBooks(bookList);
        System.out.println(bookService.saveBook(book));*/
        authorService.saveAuthor(author);
        return author;
    }

    @Test
    public void saveAuthorPositiveTest() {
        createAuthorForTest();
        Author author = new Author();
        author.setFirstName("Антон");
        author.setLastName("Николаев");
        author.setPatronymic("хз");
        Assert.assertTrue(authorService.saveAuthor(author));
    }

    @Test
    public void saveAuthorNegativeTest() {
        createAuthorForTest();
        Author author = new Author();
        author.setFirstName("Иван");
        author.setLastName("Николаев");
        author.setPatronymic("хз");
        Assert.assertTrue(authorService.saveAuthor(author));
    }

    @Test
    public void getAllAuthorsTest() {
        Assert.assertNotNull(authorService.getAllAuthors());
    }

    @Test
    public void deleteAuthorPositiveTest() {
        Author author = createAuthorForTest();
        Assert.assertNull(authorService.deleteAuthor(author));
    }

    @Test
    public void deleteAuthorNegatitiveTest() {
        Author author = createAuthorForTest();
        author.setAuthorId(35);
        Assert.assertNull(authorService.deleteAuthor(author));
    }

    @Test
    public void getAuthorByIdPositiveTest() {
        Author author = createAuthorForTest();
        Assert.assertNotNull(authorService.getAuthorById(author.getAuthorId()));
    }

    @Test
    public void getAuthorByIdNegativeTest() {
        Author author = createAuthorForTest();
        author.setAuthorId(35);
        Assert.assertNotNull(authorService.getAuthorById(author.getAuthorId()));
    }

}
