package pe.upc.bcp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.upc.bcp.entity.Notification;
import pe.upc.bcp.exception.ResourceNotFoundException;
import pe.upc.bcp.repository.AccountRepository;
import pe.upc.bcp.repository.NotificationRepository;
import pe.upc.bcp.service.NotificationService;

import java.util.List;

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
    public Notification getNotificationByIdAccount(Long notificationId, Long accountId) {
        return notificationRepository.findByIdAndAccountId(notificationId, accountId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Notification not found with Id " + notificationId +
                                " AccountId " + accountId ));
    }

    @Override
    public Notification createNotification(Long accountId, Notification notification) {
        return notificationRepository.findById(accountId).map(account -> {
            notification.setAccount(account);
            return notificationRepository.save(notification);
        }).orElseThrow(() -> new ResourceNotFoundException("Account", "Id", accountId));
    }

    @Override
    public Notification updateNotification(Long accountId, Long notificationId, Notification notificationRequest) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new ResourceNotFoundException("Notification", "Id", notificationId));
        notification.setDetail(notificationRequest.getDetail());
        notification.setName(notificationRequest.getName());
        notification.setStatus(notificationRequest.getStatus());
        notification.setDate(notificationRequest.getDate());
        return notificationRepository.save(notification);
    }

    @Override
    public ResponseEntity<?> deleteNotification(Long notificationId,Long accountId) {
        return notificationRepository.findByIdAndAccountId(notificationId, accountId).map(request -> {
            notificationRepository.delete(request);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Notification not found with Id " + notificationId + " AccountId " + accountId + "and InternshipId"
        ));
    }

}
