package br.mentorama.Freebook.controllers;

import br.mentorama.Freebook.dto.NewBookRequest;
import br.mentorama.Freebook.entities.Book;
import br.mentorama.Freebook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("books")
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping("new")
    public String newBook() {
        return "books/new";
    }

    @PostMapping
    public String create(NewBookRequest newBookRequest) {
        Book newBook = bookService.create(newBookRequest);

        System.out.println(newBook);
        return "books/index";
    }

}
