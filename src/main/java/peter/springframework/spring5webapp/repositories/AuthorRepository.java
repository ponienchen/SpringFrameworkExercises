package peter.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import peter.springframework.spring5webapp.model.book.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {



}
