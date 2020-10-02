
package pe.upc.bcp.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.bcp.entity.Notification;
import pe.upc.bcp.resource.NotificationResource;
import pe.upc.bcp.resource.SaveNotificationResource;
import pe.upc.bcp.service.NotificationService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class NotificationController {


    @Autowired
    private ModelMapper mapper;

    @Autowired
    private NotificationService notificationService;


    @GetMapping("/notifications")
    public org.springframework.data.domain.Page<NotificationResource> getAllNotifications(org.springframework.data.domain.Pageable pageable){
        List<NotificationResource> notifiacations = notificationService.getAllNotifications(pageable)
                .getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        int notificationCount = notifiacations.size();
        return new PageImpl<>(notifiacations, pageable, notificationCount);
    }


    @GetMapping("/accounts/{accountId}/notifications")
    public org.springframework.data.domain.Page<NotificationResource> getAllNotifiactionsByUserId(
            @PathVariable(name = "notificationId") Long notificationId,
            Pageable pageable)
    {
        Page<Notification> notificationsPage = notificationService.getAllNotificationsByAccountId(notificationId, pageable);
        List<NotificationResource> notifications = notificationsPage.getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(notifications, pageable, notifications.size());
    }

    @GetMapping("/accounts/{accountId}/notifications/{notificationId}")
    public NotificationResource getNotificationByIdAndAccountId(@PathVariable(name = "accountId") Long accountId,
                                                    @PathVariable(name = "notificationId") Long notificationId){
        return convertToResource(notificationService.getNotificationByIdAccount(accountId,notificationId));
    }

    @PostMapping("/account/{accountId}/notifiactions")
    public NotificationResource createNotifiactions(@PathVariable(name = "accountId") Long accountId,
                                          @Valid @RequestBody SaveNotificationResource resource){
        return convertToResource(notificationService.createNotification( accountId,convertToEntity(resource)));
    }

    @PutMapping("/accounts/{accountId}/notifications/{notificationId}")
    public NotificationResource updateNotification(@PathVariable(name= "accountId") Long accountId,
                                         @PathVariable(name = "notificationId") Long notificationId,
                                         @Valid @RequestBody SaveNotificationResource resource){
        return convertToResource(notificationService.updateNotification(accountId, notificationId, convertToEntity(resource)));
    }

    @DeleteMapping("/accounts/{accountId}/notifications/{notificationsId}")
    public ResponseEntity<?> deleteNotifications(@PathVariable(name = "accountId") Long accountId,
                                            @PathVariable(name="notifiactionsId") Long notifiactionsId){
        return  notificationService.deleteNotification(accountId, notifiactionsId);
    }

    private Notification convertToEntity(SaveNotificationResource resource) { return mapper.map(resource, Notification.class); }

    private NotificationResource convertToResource(Notification entity) { return mapper.map(entity, NotificationResource.class); }
}