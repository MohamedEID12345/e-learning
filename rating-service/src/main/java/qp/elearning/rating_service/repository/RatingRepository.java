package qp.elearning.rating_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import qp.elearning.rating_service.model.Rating;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findByCourseId(Long courseId);
    List<Rating> findByUserId(Long userId);
}
