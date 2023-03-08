package br.mentorama.Freebook.services;

import br.mentorama.Freebook.dto.NewBookRequest;
import br.mentorama.Freebook.dto.UpdateBookRequest;
import br.mentorama.Freebook.entities.Book;
import br.mentorama.Freebook.entities.User;
import br.mentorama.Freebook.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    private final String IMAGES_DIRECTORY = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "static" + File.separator + "images";

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UsersService usersService;

    public List<Book> findAvailableBooks() {
        return bookRepository.findAvailableBooks();
    }

    public Book create(NewBookRequest newBookRequest, MultipartFile bookCoverFile) {
        String uploadPath = System.getProperty("user.dir") + File.separator + IMAGES_DIRECTORY;

        String filename = UUID.randomUUID() + "-" + bookCoverFile.getOriginalFilename();
        File uploadedFilePath = new File(uploadPath + File.separator + filename);

        try {
            bookCoverFile.transferTo(uploadedFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Book book = new Book(newBookRequest.getTitle(),
                newBookRequest.getAuthor(),
                newBookRequest.getGender(),
                newBookRequest.getIsbn(),
                newBookRequest.getYear(),
                newBookRequest.getSynopsis(),
                newBookRequest.getEdition(),
                newBookRequest.getPublisher());

        book.setCoverPath(File.separator + "images" + File.separator + filename);

        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = usersService.findByEmail(email);
        book.setUser(user);

        return bookRepository.save(book);
    }

    public Book find(UUID id) {
        return bookRepository.findById(id).get();
    }

    public Book update(UUID id, UpdateBookRequest updateBookRequest) {
        Book book = bookRepository.findById(id).get();

        book.setTitle(updateBookRequest.getTitle());
        book.setAuthor(updateBookRequest.getAuthor());
        book.setPublicationYear(updateBookRequest.getYear());
        book.setEdition(updateBookRequest.getEdition());
        book.setGender(updateBookRequest.getGender());
        book.setPublisher(updateBookRequest.getPublisher());
        book.setIsbn(updateBookRequest.getIsbn());
        book.setSynopsis(updateBookRequest.getSynopsis());

        return bookRepository.save(book);
    }
}
