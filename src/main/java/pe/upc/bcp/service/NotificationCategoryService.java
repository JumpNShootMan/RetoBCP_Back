package pe.upc.bcp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.upc.bcp.entity.Notification;
import pe.upc.bcp.entity.NotificationCategory;

public interface NotificationCategoryService {
    Page<NotificationCategory> getAllNotificationCategories(Pageable pageable);
    //Page<Notification> getAllNotificationsByAccountId(Long accountId, Pageable pageable);
    NotificationCategory getNotificationCategoryById(Long notificationId);
    //Notification getNotificationByIdAccount(Long notificationId, Long accountId);
    NotificationCategory createNotificationCategory(NotificationCategory notificationCategory);
    NotificationCategory updateNotificationCategory(Long notificationId,NotificationCategory notificationCategoryRequest);
    ResponseEntity<?> deleteNotificationCategory(Long notificationCategoryId);
}
