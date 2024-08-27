package qp.elearning.rating_service.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "user_id")
    private Long userId;

    private int stars;
    private String comment;
}
