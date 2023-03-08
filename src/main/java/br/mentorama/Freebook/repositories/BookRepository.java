package br.mentorama.Freebook.repositories;

import br.mentorama.Freebook.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
    @Query("SELECT b FROM Book b WHERE b.available = true")
    List<Book> findAvailableBooks();
}
