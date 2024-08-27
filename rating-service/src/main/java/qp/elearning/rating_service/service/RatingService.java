package qp.elearning.rating_service.service;

import qp.elearning.rating_service.dto.RatingDTO;

import java.util.List;

public interface RatingService {

    void createRating(RatingDTO ratingDTO);
    List<RatingDTO> getRatingsByCourse(Long courseId);
    List<RatingDTO> getRatingsByUser(Long userId);
}
