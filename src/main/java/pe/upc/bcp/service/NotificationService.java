package pe.upc.bcp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.upc.bcp.entity.Notification;

public interface NotificationService {
    Page<Notification> getAllNotifications(Pageable pageable);
    Page<Notification> getAllNotificationsByAccountId(Long accountId, Pageable pageable);

    Notification getNotificationByIdAccount(Long notificationId, Long accountId);
    Notification createNotification(Long accountId, Notification notification);
    Notification updateNotification(Long accountId, Long notificationId, Notification notificationRequest);
    ResponseEntity<?> deleteNotification(Long notificationId, Long accountId);
/*
    Notification assignNotificationAccount(Long notificationId, Long accountId);
    Notification unAssignNotificationAccount(Long notificationId, Long accountId);
*/
}
