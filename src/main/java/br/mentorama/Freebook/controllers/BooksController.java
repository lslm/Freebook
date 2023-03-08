package br.mentorama.Freebook.controllers;

import br.mentorama.Freebook.dto.NewBookRequest;
import br.mentorama.Freebook.dto.UpdateBookRequest;
import br.mentorama.Freebook.entities.Book;
import br.mentorama.Freebook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("books")
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String index(Model model) {
        List<Book> books = bookService.findAvailableBooks();
        model.addAttribute("books", books);
        return "books/index";
    }

    @GetMapping("new")
    public String newBook() {
        return "books/new";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable UUID id, Model model) {
        Book book = bookService.find(id);
        model.addAttribute("book", book);
        return "books/show";
    }

    @PostMapping
    public String create(NewBookRequest newBookRequest, @RequestParam("cover") MultipartFile bookCoverFile) {
        bookService.create(newBookRequest, bookCoverFile);
        return "redirect:books";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable UUID id, Model model) {
        Book book = bookService.find(id);
        model.addAttribute("book", book);
        return "books/edit";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable UUID id, UpdateBookRequest updateBookRequest) {
        System.out.println(id);
        System.out.println(updateBookRequest);

        bookService.update(id, updateBookRequest);

        return "redirect:/books";
    }

}
