package qp.elearning.notification_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import qp.elearning.notification_service.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
