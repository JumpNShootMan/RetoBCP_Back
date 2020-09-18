package pe.upc.bcp.service;

import pe.upc.bcp.entity.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationService {
    List<Notification> getAllNotifications();
    Optional<Notification> findById(Long id);
    Optional<Notification> getNotificationByAccountId(Long id);
}
