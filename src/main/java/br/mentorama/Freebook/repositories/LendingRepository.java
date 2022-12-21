package br.mentorama.Freebook.repositories;

import br.mentorama.Freebook.entities.Lending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LendingRepository extends JpaRepository<Lending, UUID> {}
