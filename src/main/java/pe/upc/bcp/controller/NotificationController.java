/*
package pe.upc.bcp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.bcp.entity.Notification;
import pe.upc.bcp.service.NotificationService;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public ResponseEntity<List<Notification>>getAll(){return ResponseEntity.ok().body(notificationService.getAllNotifications());}

    @GetMapping(value="/notifications/{id}")
    ResponseEntity<Notification> getById(@PathVariable("id") @Min(1) Long id) {
        Notification notification = notificationService.findById(id)
                .orElseThrow(()->new NotificationNotFoundException("No Notification with ID : "+id));
        return ResponseEntity.ok().body(notification);
    }

    @GetMapping(value="/notifications/account/{id}")
    public ResponseEntity<Notification> findUserByAccountId(@PathVariable("id") Long id) {

        //ResponseEntity<Notification> response = new ResponseEntity<Notification>();
        Notification notification = notificationService.getNotificationByAccountId(id)
                .orElseThrow(()->new NotificationNotFoundException("No Product with AccountID"+id));
        return ResponseEntity.ok().body(notification);


        //response.setData(this.convertEntityToDto(user.get()));
        //return ResponseEntity.ok().body(response);
    }
}*/