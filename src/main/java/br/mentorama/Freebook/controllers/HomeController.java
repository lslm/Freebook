package br.mentorama.Freebook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping
    public String home(Model model) {
        String welcomeMessage = "FreeBook é a plataforma compartilhamento de livros. Doe e compartilhe livros que pessoas do Brasil todo disponibilizam";

        model.addAttribute("welcomeMessage", welcomeMessage);
        return "home";
    }

}
