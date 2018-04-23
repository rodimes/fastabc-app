package br.com.fastabc.repo;

import br.com.fastabc.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
    Optional<Book> findById(Long id);
}
