package qp.elearning.notification_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qp.elearning.notification_service.dto.NotificationDTO;
import qp.elearning.notification_service.model.Notification;
import qp.elearning.notification_service.repository.NotificationRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public NotificationDTO createNotification(NotificationDTO notificationDTO) {
        Notification notification = new Notification();
        notification.setTitle(notificationDTO.getTitle());
        notification.setMessage(notificationDTO.getMessage());
        notification.setUserId(notificationDTO.getUserId());
        notification.setTimestamp(notificationDTO.getTimestamp());

        Notification savedNotification = notificationRepository.save(notification);
        return convertToDTO(savedNotification);
    }

    @Override
    public NotificationDTO getNotificationById(Long id) {
        Optional<Notification> notification = notificationRepository.findById(id);
        return notification.map(this::convertToDTO).orElse(null);
    }

    @Override
    public List<NotificationDTO> getAllNotifications() {
        List<Notification> notifications = notificationRepository.findAll();
        return notifications.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }

    private NotificationDTO convertToDTO(Notification notification) {
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setId(notification.getId());
        notificationDTO.setTitle(notification.getTitle());
        notificationDTO.setMessage(notification.getMessage());
        notificationDTO.setUserId(notification.getUserId());
        notificationDTO.setTimestamp(notification.getTimestamp());
        return notificationDTO;
    }
}
