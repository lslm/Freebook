package br.mentorama.Freebook.services;

import br.mentorama.Freebook.entities.Book;
import br.mentorama.Freebook.entities.Lending;
import br.mentorama.Freebook.entities.User;
import br.mentorama.Freebook.repositories.LendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LendingService {
    @Autowired
    private LendingRepository lendingRepository;

    public Lending create(User user, Book book) {
        Lending lending = new Lending();
        lending.setUser(user);
        lending.setBook(book);

        return lendingRepository.save(lending);
    }

    public List<Lending> findLendingsByUser(User user) {
        List<Lending> lendings = lendingRepository.findByUser(user);
        return lendings;
    }
}
