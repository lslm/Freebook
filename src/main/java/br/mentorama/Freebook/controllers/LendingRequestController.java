package br.mentorama.Freebook.controllers;

import br.mentorama.Freebook.entities.LendingRequest;
import br.mentorama.Freebook.services.LendingRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("lending-requests")
public class LendingRequestController {
    @Autowired
    private LendingRequestService lendingRequestService;

    @PostMapping("/book/{bookId}")
    public String create(@PathVariable UUID bookId) {
        LendingRequest lendingRequest = lendingRequestService.create(bookId);

        return "redirect:/books";
    }

    @GetMapping
    public String index(Model model) {
        List<LendingRequest> requests = lendingRequestService.findMyRequests();
        model.addAttribute("lendingsRequests", requests);
        return "lendingRequests/index";
    }

    @PostMapping("/{id}/approve")
    public String approveRequest(@PathVariable UUID id) {
        lendingRequestService.approveRequest(id);
        return "redirect:/lending-requests";
    }
}
