package br.mentorama.Freebook.repositories;

import br.mentorama.Freebook.entities.LendingRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LendingRequestRepository extends JpaRepository<LendingRequest, UUID> {
    @Query("SELECT l FROM LendingRequest l WHERE l.book.user.id = ?1")
    List<LendingRequest> findByBookOwner(UUID userId);

    @Query("SELECT l FROM LendingRequest l WHERE l.book.user.id = ?1 AND l.approved = false")
    List<LendingRequest> findPendingRequests(UUID userId);
}
