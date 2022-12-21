package br.mentorama.Freebook.repositories;

import br.mentorama.Freebook.entities.Lending;
import br.mentorama.Freebook.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LendingRepository extends JpaRepository<Lending, UUID> {
    List<Lending> findByUser(User user);
}
