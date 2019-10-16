package group.modulelibrary.rest.controller;

import group.modulelibrary.dto.BookDto;
import group.modulelibrary.mapper.BookMapper;
import group.modulelibrary.model.Book;
import group.modulelibrary.service.api.BookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/book", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BookRestController {

    private BookService bookService;
    private BookMapper bookMapper;

    @Autowired
    public BookRestController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @ApiOperation("Get all books")
    @GetMapping("")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        List<Book> bookList = this.bookService.getAllBooks();
        if (bookList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(bookMapper.toDtoBookList(bookList), HttpStatus.OK);
        }
    }

    @ApiOperation("Add new book")
    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addBook (@RequestBody @Valid BookDto bookDto) {
        if (bookDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            this.bookService.saveBook(bookMapper.toBook(bookDto));
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @ApiOperation("Edit Book")
    @PutMapping("/edit")
    public ResponseEntity<HttpStatus> editBook (@RequestBody @Valid BookDto bookDto) {
        if (bookDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Book book = bookMapper.toBook(bookDto);
            this.bookService.saveBook(book);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @ApiOperation("Delete book by id")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteBook (@PathVariable("id") int id) {
        Book book = this.bookService.getBookById(id);
        if (book == null)  {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            this.bookService.deleteBook(book);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @ApiOperation("Get book by id")
    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBook (@PathVariable("id") Integer id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Book book = this.bookService.getBookById(id);
            if (book == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(bookMapper.toDtoBook(book), HttpStatus.OK);
            }
        }
    }
}
