package br.mentorama.Freebook.controllers;

import br.mentorama.Freebook.dto.NewBookRequest;
import br.mentorama.Freebook.entities.Book;
import br.mentorama.Freebook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("books")
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String index(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "books/index";
    }

    @GetMapping("new")
    public String newBook() {
        return "books/new";
    }

    @PostMapping
    public String create(NewBookRequest newBookRequest) {
        bookService.create(newBookRequest);
        return "redirect:books";
    }

}
