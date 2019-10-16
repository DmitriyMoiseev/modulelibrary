package group.modulelibrary.web.controller;

import group.modulelibrary.model.Book;
import group.modulelibrary.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private BookServiceImpl bookService;

    @Autowired
    public BookController(BookServiceImpl bookService){
        this.bookService = bookService;
    }

    @GetMapping("")
    public ModelAndView showAllBooks() {
        List<Book> books = bookService.getAllBooks();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("books");
        modelAndView.addObject("bookList", books);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditBookPage(@PathVariable("id") int id) {
        Book book = bookService.getBookById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editBookPage");
        modelAndView.addObject("book", book);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editBook(@ModelAttribute("book") Book book) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/book/");
        bookService.saveBook(book);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView showBookAddPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editBookPage");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addBook(@ModelAttribute("book") Book book) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/book");
        bookService.saveBook(book);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteBook(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/book");
        Book book = bookService.getBookById(id);
        bookService.deleteBook(book);
        return modelAndView;
    }
}
