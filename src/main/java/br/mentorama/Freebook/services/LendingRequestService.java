package br.mentorama.Freebook.services;

import br.mentorama.Freebook.entities.Book;
import br.mentorama.Freebook.entities.LendingRequest;
import br.mentorama.Freebook.entities.User;
import br.mentorama.Freebook.repositories.LendingRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LendingRequestService {

    @Autowired
    private UsersService usersService;

    @Autowired
    private BookService bookService;

    @Autowired
    private LendingRequestRepository lendingRequestRepository;

    public LendingRequest create(UUID bookId) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = usersService.findByEmail(email);
        Book book = bookService.find(bookId);

        LendingRequest lendingRequest = new LendingRequest();
        lendingRequest.setBook(book);
        lendingRequest.setRequestedBy(user);

        return lendingRequestRepository.save(lendingRequest);
    }

    public List<LendingRequest> findMyRequests() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = usersService.findByEmail(email);

        return lendingRequestRepository.findByBookOwner(user.getId());
    }
}
