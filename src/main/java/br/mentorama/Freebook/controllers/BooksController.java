package br.mentorama.Freebook.controllers;

import br.mentorama.Freebook.dto.NewBookRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("books")
public class BooksController {


    @GetMapping("new")
    public String newBook() {
        return "books/new";
    }

    @PostMapping
    public String create(NewBookRequest newBookRequest) {
        System.out.println(newBookRequest);
        return "books/index";
    }

}
