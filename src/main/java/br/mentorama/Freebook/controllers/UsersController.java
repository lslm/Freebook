package br.mentorama.Freebook.controllers;

import br.mentorama.Freebook.dto.NewUserRequest;
import br.mentorama.Freebook.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("new")
    public String newUser() {
        return "users/new";
    }

    @PostMapping
    public String create(NewUserRequest newUserRequest) {
        usersService.create(newUserRequest);
        return "redirect:/login";
    }
}
