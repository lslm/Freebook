package br.mentorama.Freebook.controllers;

import br.mentorama.Freebook.entities.Book;
import br.mentorama.Freebook.entities.Lending;
import br.mentorama.Freebook.entities.User;
import br.mentorama.Freebook.services.BookService;
import br.mentorama.Freebook.services.LendingService;
import br.mentorama.Freebook.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("lendings")
public class LendingsController {

    @Autowired
    private LendingService lendingService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private BookService bookService;

    @PostMapping("/books/{bookId}")
    public String create(@PathVariable UUID bookId) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = usersService.findByEmail(email);
        Book book = bookService.find(bookId);

        Lending lending = lendingService.create(user, book);
        System.out.println(lending);

        return "redirect:/books";
    }

    @GetMapping("/{id}")
    private String find(@PathVariable UUID id, Model model) {
        Lending lending = lendingService.findById(id);

        model.addAttribute("lending", lending);

        return "lendings/show";
    }

    @GetMapping
    public String index(Model model) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = usersService.findByEmail(email);

        List<Lending> lendings = lendingService.findLendingsByUser(user);

        model.addAttribute("lendings", lendings);

        return "lendings/index";
    }
}
