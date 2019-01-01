package peter.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import peter.springframework.spring5webapp.model.book.Author;

//Spring Data Repositories (JPA)
// - Provides an implementation of the repository pattern
// - You extend a Java Repository Interface, and Spring Data JPA will provides the implementation AT runtime.
public interface AuthorRepository extends CrudRepository<Author, Long> {



}
