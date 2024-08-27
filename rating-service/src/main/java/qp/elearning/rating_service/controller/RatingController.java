package qp.elearning.rating_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qp.elearning.rating_service.dto.RatingDTO;
import qp.elearning.rating_service.model.Rating;
import qp.elearning.rating_service.service.RatingService;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;


    @PostMapping
    public ResponseEntity<?> createRating(@RequestBody RatingDTO ratingDTO) {
        ratingService.createRating(ratingDTO);
        return ResponseEntity.ok("Rating created successfully");
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<RatingDTO>> getRatingsByCourse(@PathVariable Long courseId) {
        List<RatingDTO> ratings = ratingService.getRatingsByCourse(courseId);
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RatingDTO>> getRatingsByUser(@PathVariable Long userId) {
        List<RatingDTO> ratings = ratingService.getRatingsByUser(userId);
        return ResponseEntity.ok(ratings);
    }
}
