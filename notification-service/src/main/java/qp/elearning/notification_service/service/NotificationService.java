package qp.elearning.notification_service.service;

import qp.elearning.notification_service.dto.NotificationDTO;

import java.util.List;

public interface NotificationService {

    NotificationDTO createNotification(NotificationDTO notificationDTO);

    NotificationDTO getNotificationById(Long id);

    List<NotificationDTO> getAllNotifications();

    void deleteNotification(Long id);
}
