package br.mentorama.Freebook.services;

import br.mentorama.Freebook.dto.NewBookRequest;
import br.mentorama.Freebook.dto.UpdateBookRequest;
import br.mentorama.Freebook.entities.Book;
import br.mentorama.Freebook.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book create(NewBookRequest newBookRequest) {
        Book book = new Book(newBookRequest.getTitle(),
                newBookRequest.getAuthor(),
                newBookRequest.getGender(),
                newBookRequest.getIsbn(),
                newBookRequest.getYear(),
                newBookRequest.getSynopsis(),
                newBookRequest.getEdition(),
                newBookRequest.getPublisher());

        return bookRepository.save(book);
    }

    public Book find(UUID id) {
        return bookRepository.findById(id).get();
    }

    public Book update(UUID id, UpdateBookRequest updateBookRequest) {
        Book book = bookRepository.findById(id).get();

        book.setTitle(updateBookRequest.getTitle());
        book.setAuthor(updateBookRequest.getAuthor());
        book.setAno(updateBookRequest.getYear());
        book.setEdition(updateBookRequest.getEdition());
        book.setGender(updateBookRequest.getGender());
        book.setPublisher(updateBookRequest.getPublisher());
        book.setIsbn(updateBookRequest.getIsbn());
        book.setSynopsis(updateBookRequest.getSynopsis());

        return bookRepository.save(book);
    }
}
