package web.intro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.intro.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
