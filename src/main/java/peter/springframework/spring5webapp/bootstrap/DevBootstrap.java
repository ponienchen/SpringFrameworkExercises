package peter.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import peter.springframework.spring5webapp.model.book.Author;
import peter.springframework.spring5webapp.model.book.Book;
import peter.springframework.spring5webapp.model.book.Publisher;
import peter.springframework.spring5webapp.repositories.AuthorRepository;
import peter.springframework.spring5webapp.repositories.BookRepository;
import peter.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Publisher publisher = new Publisher("Peter's Heaven", "333 X Street, Fremont, CA 94536");
        this.publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        this.authorRepository.save(eric);
        this.bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisher);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        this.authorRepository.save(rod);
        this.bookRepository.save(noEJB);

    }
}
