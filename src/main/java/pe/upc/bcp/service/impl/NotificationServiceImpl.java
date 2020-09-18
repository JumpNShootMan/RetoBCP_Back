package pe.upc.bcp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upc.bcp.entity.Notification;
import pe.upc.bcp.repository.NotificationRepository;
import pe.upc.bcp.service.NotificationService;

import java.util.List;
import java.util.Optional;
@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAllNotifications();
    }

    @Override
    public Optional<Notification> findById(Long id) {
        return notificationRepository.findById(id);
    }

    @Override
    public Optional<Notification> getNotificationByAccountId(Long id) {
        return notificationRepository.findNotificationByAccountId(id);
    }
}
