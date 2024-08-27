package qp.elearning.notification_service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class NotificationDTO {

    private Long id;
    private String title;
    private String message;
    private Long userId;
    private LocalDateTime timestamp;
}
