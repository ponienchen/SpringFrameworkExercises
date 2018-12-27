package peter.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import peter.springframework.spring5webapp.model.book.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
