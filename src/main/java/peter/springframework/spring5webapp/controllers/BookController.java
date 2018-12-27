package peter.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import peter.springframework.spring5webapp.repositories.BookRepository;

//This annotation makes this class a Spring Bean, which is a Spring-managed
//component, and because a constructor has been provided, therefore Spring will
//automatically auto-wire in for us the bookRepository instance.
@Controller
public class BookController {

    private BookRepository bookRepository;

//  When this controller is invoked, Spring will inject the instance of
//  the bookRepository here into the BookController Constructor.
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

//  Model is an interface whose implementation will be passed in by Spring
//  for us during runtime.
    @RequestMapping("/books")
    public String getBooks(Model model) {
//      bookRepository will use Spring Data JPA, which will use Hibernate to
//      retrieve a list of books from the database.
        model.addAttribute("books", this.bookRepository.findAll());

//      This tells the Spring MVC to associate this with a view called "books".
        return "books";
    }
}
