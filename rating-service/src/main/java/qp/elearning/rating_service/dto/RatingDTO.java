package qp.elearning.rating_service.dto;

import lombok.Data;

@Data
public class RatingDTO {

    private Long id;
    private Long courseId;
    private Long userId;
    private int stars;
    private String comment;
}
