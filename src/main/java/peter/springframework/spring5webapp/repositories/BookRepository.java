package peter.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import peter.springframework.spring5webapp.model.book.Book;

public interface BookRepository extends CrudRepository<Book, Long> {


}
