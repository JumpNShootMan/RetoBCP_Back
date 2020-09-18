package pe.upc.bcp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.upc.bcp.entity.Account;
import pe.upc.bcp.entity.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
    @Query("SELECT n FROM Notification n")
    List<Notification> findAllNotifications();

    @Query("SELECT n FROM Notification n WHERE n.account.id=?1")
    Optional<Notification> findNotificationByAccountId(Long accountId);
}
