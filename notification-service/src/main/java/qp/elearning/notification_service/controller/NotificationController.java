package qp.elearning.notification_service.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qp.elearning.notification_service.dto.NotificationDTO;
import qp.elearning.notification_service.service.NotificationService;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<NotificationDTO> createNotification(@RequestBody @Valid NotificationDTO notificationDTO) {
        NotificationDTO createdNotification = notificationService.createNotification(notificationDTO);
        return new ResponseEntity<>(createdNotification, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationDTO> getNotificationById(@PathVariable Long id) {
        NotificationDTO notificationDTO = notificationService.getNotificationById(id);
        return new ResponseEntity<>(notificationDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<NotificationDTO>> getAllNotifications() {
        List<NotificationDTO> notifications = notificationService.getAllNotifications();
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
