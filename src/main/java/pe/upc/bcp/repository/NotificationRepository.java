package pe.upc.bcp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.upc.bcp.entity.Account;
import pe.upc.bcp.entity.Notification;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long> {
    Page<Notification> findByAccountId(Long accountId, Pageable pageable);
    Optional<Notification> findByIdAndAccountId(Long id, Long accountId);
}
