/*
package pe.upc.bcp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.upc.bcp.entity.Account;
import pe.upc.bcp.entity.Notification;
import pe.upc.bcp.exception.ResourceNotFoundException;
import pe.upc.bcp.repository.AccountRepository;
import pe.upc.bcp.repository.NotificationRepository;
import pe.upc.bcp.service.NotificationService;

import java.util.List;
import java.util.Optional;
@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Page<Notification> getAllNotifications(Pageable pageable) {
        return notificationRepository.findAll(pageable);
    }

    @Override
    public Page<Notification> getAllNotificationsByAccountId(Long accountId, Pageable pageable) {
        return accountRepository.findById(accountId).map(account -> {
            List<Notification> notifications = account.getNotifications();
            int notificationCount = notifications.size();
            return new PageImpl<>(notifications, pageable, notificationCount);
        })
                .orElseThrow(() -> new ResourceNotFoundException("Account", "Id", accountId));
    }

    @Override
    public Notification getNotificationById(Long notificationId) {
        return notificationRepository.findById(notificationId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", notificationId));
    }

    @Override
    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification updateNotification(Long notificationId, Notification notificationRequest) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new ResourceNotFoundException("Notification", "Id", notificationId));
        notification.setDetail(notificationRequest.getDetail());
        notification.setName(notificationRequest.getName());
        notification.setStatus(notificationRequest.getStatus());
        notification.setDate(notificationRequest.getDate());
        return notificationRepository.save(notification);
    }

    @Override
    public ResponseEntity<?> deleteNotification(Long notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new ResourceNotFoundException("Notification", "Id", notificationId));
        notificationRepository.delete(notification);
        return ResponseEntity.ok().build();
    }

}
*/
