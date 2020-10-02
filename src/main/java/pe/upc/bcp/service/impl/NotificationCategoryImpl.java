package pe.upc.bcp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.upc.bcp.entity.Notification;
import pe.upc.bcp.entity.NotificationCategory;
import pe.upc.bcp.exception.ResourceNotFoundException;
import pe.upc.bcp.repository.AccountRepository;
import pe.upc.bcp.repository.NotificationCategoryRepository;
import pe.upc.bcp.repository.NotificationRepository;
import pe.upc.bcp.service.NotificationCategoryService;

@Service
public class NotificationCategoryImpl implements NotificationCategoryService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private NotificationCategoryRepository notificationCategoryRepository;

    @Override
    public Page<NotificationCategory> getAllNotificationCategories(Pageable pageable) {
        return notificationCategoryRepository.findAll(pageable);
    }

    @Override
    public NotificationCategory getNotificationCategoryById(Long notificationId) {
        return null;
    }

    @Override
    public NotificationCategory createNotificationCategory(NotificationCategory notificationCategory) {
        return notificationCategoryRepository.save(notificationCategory);
    }

    @Override
    public NotificationCategory updateNotificationCategory(Long notificationId, NotificationCategory notificationCategoryRequest) {
        return notificationCategoryRepository.findById(notificationId).map(notificationCategory -> {
            notificationCategory.setName(notificationCategoryRequest.getName());
            notificationCategory.setSound(notificationCategoryRequest.getSound());
            return notificationCategoryRepository.save(notificationCategory);
        }).orElseThrow(() -> new ResourceNotFoundException("NotificationCategory", "Id", notificationId));
    }

    @Override
    public ResponseEntity<?> deleteNotificationCategory(Long notificationCategoryId) {
        return null;
    }
}
