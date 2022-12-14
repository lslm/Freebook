package br.mentorama.Freebook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("users")
public class UsersController {
    @GetMapping("new")
    public String newUser() {
        return "users/new";
    }
}
