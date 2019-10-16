package group.modulelibrary.rest.controller;

import group.modulelibrary.dto.AuthorDto;
import group.modulelibrary.dto.BookDto;
import group.modulelibrary.mapper.AuthorMapper;
import group.modulelibrary.mapper.BookMapper;
import group.modulelibrary.model.Author;
import group.modulelibrary.model.Book;
import group.modulelibrary.service.api.AuthorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/author", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AuthorRestController {

    private AuthorService authorService;
    private AuthorMapper authorMapper;
    private BookMapper bookMapper;

    @Autowired
    public AuthorRestController(AuthorService authorService, AuthorMapper authorMapper, BookMapper bookMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
        this.bookMapper = bookMapper;
    }

    @ApiOperation("Get all authors")
    @GetMapping("")
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        List<Author> authorList = this.authorService.getAllAuthors();
        if (authorList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(authorMapper.toAuthorDtoList(authorList), HttpStatus.OK);
        }
    }

    @ApiOperation("Add new author")
    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addAuthor (@RequestBody @Valid AuthorDto authorDto) {
        if (authorDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            this.authorService.saveAuthor(authorMapper.toAuthor(authorDto));
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @ApiOperation("Edit author")
    @PutMapping("/edit")
    public ResponseEntity<HttpStatus> editAuthor (@RequestBody @Valid AuthorDto authorDto) {
        if (authorDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Author author = authorMapper.toAuthor(authorDto);
            this.authorService.saveAuthor(author);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @ApiOperation("Delete author by id")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteAuthor (@PathVariable("id") int id) {
        Author author = this.authorService.getAuthorById(id);
        if (author == null)  {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            this.authorService.deleteAuthor(author);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @ApiOperation("Get author by id")
    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthor (@PathVariable("id") Integer id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Author author = this.authorService.getAuthorById(id);
            if (author == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(authorMapper.toDtoAuthor(author), HttpStatus.OK);
            }
        }
    }

    @ApiOperation("Show all author's books")
    @GetMapping("/show/{id}")
    public ResponseEntity<List<BookDto>> showBooksOfAuthor (@PathVariable("id") int id) {
        Author author = this.authorService.getAuthorById(id);
        if (author == null)  {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            List<Book> bookList = this.authorService.getBooks(author);
            return new ResponseEntity<>(bookMapper.toDtoBookList(bookList), HttpStatus.OK);
        }
    }
}
