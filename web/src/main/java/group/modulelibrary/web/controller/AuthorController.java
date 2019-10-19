package group.modulelibrary.web.controller;

import group.modulelibrary.model.Author;
import group.modulelibrary.model.Book;
import group.modulelibrary.service.impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private AuthorServiceImpl authorService;

    @Autowired
    public AuthorController(AuthorServiceImpl authorService){
        this.authorService = authorService;
    }

    @GetMapping("")
    public ModelAndView showAllAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("authors");
        modelAndView.addObject("authorList", authors);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditAuthorPage(@PathVariable("id") int id) {
        Author author = authorService.getAuthorById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editAuthorPage");
        modelAndView.addObject("author", author);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editAuthor(@ModelAttribute("author") Author author) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/author/");
        authorService.saveAuthor(author);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView showAuthorAddPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editAuthorPage");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addAuthor(@ModelAttribute("author") Author author) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/author");
        authorService.saveAuthor(author);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteAuthor(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/author");
        Author author = authorService.getAuthorById(id);
        authorService.deleteAuthor(author);
        return modelAndView;
    }

    @GetMapping("/show/{id}")
    public ModelAndView showBooksOfAuthor(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("books");
        Author author = authorService.getAuthorById(id);
        List<Book> books = author.getBooks();
        modelAndView.addObject("bookList", books);
        return modelAndView;
    }
}
