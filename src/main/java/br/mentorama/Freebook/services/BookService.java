package br.mentorama.Freebook.services;

import br.mentorama.Freebook.dto.NewBookRequest;
import br.mentorama.Freebook.entities.Book;
import br.mentorama.Freebook.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

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
}
