package pe.upc.bcp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.upc.bcp.entity.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationService {
    Page<Notification> getAllNotifications(Pageable pageable);
    Page<Notification> getAllNotificationsByAccountId(Long accountId, Pageable pageable);

    Notification getNotificationById(Long notificationId);
    Notification createNotification(Notification notification);
    Notification updateNotification(Long notificationId, Notification notificationRequest);
    ResponseEntity<?> deleteNotification(Long notificationId);
/*
    Notification assignNotificationAccount(Long notificationId, Long accountId);
    Notification unAssignNotificationAccount(Long notificationId, Long accountId);
*/
}
