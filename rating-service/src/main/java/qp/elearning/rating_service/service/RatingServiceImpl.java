package qp.elearning.rating_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qp.elearning.rating_service.dto.RatingDTO;
import qp.elearning.rating_service.model.Rating;
import qp.elearning.rating_service.repository.RatingRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;


    

    @Override
    public void createRating(RatingDTO ratingDTO) {
        Rating rating = new Rating();
        rating.setCourseId(ratingDTO.getCourseId());
        rating.setUserId(ratingDTO.getUserId());
        rating.setStars(ratingDTO.getStars());
        rating.setComment(ratingDTO.getComment());
        ratingRepository.save(rating);
    }

    @Override
    public List<RatingDTO> getRatingsByCourse(Long courseId) {
        List<Rating> ratings = ratingRepository.findByCourseId(courseId);
        return ratings.stream()
                .map(rating -> {
                    RatingDTO dto = new RatingDTO();
                    dto.setId(rating.getId());
                    dto.setCourseId(rating.getCourseId());
                    dto.setUserId(rating.getUserId());
                    dto.setStars(rating.getStars());
                    dto.setComment(rating.getComment());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<RatingDTO> getRatingsByUser(Long userId) {
        List<Rating> ratings = ratingRepository.findByUserId(userId);
        return ratings.stream()
                .map(rating -> {
                    RatingDTO dto = new RatingDTO();
                    dto.setId(rating.getId());
                    dto.setCourseId(rating.getCourseId());
                    dto.setUserId(rating.getUserId());
                    dto.setStars(rating.getStars());
                    dto.setComment(rating.getComment());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
