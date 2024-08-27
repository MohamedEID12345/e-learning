package qp.elearning.course_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import qp.elearning.course_service.model.Content;
import qp.elearning.course_service.model.Course;
import qp.elearning.course_service.model.Quiz;
import qp.elearning.course_service.service.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Endpoint accessible by TEACHER and ADMIN
    @PostMapping
    @PreAuthorize("hasRole('TEACHER') or hasRole('ADMIN')")
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    // Endpoint accessible by STUDENT, TEACHER, and ADMIN
    @GetMapping
    @PreAuthorize("hasRole('STUDENT') or hasRole('TEACHER') or hasRole('ADMIN')")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    // Endpoint accessible by STUDENT, TEACHER, and ADMIN
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('STUDENT') or hasRole('TEACHER') or hasRole('ADMIN')")
    public Optional<Course> getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    // Endpoint accessible by TEACHER and ADMIN
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('TEACHER') or hasRole('ADMIN')")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
        return courseService.updateCourse(id, course);
    }

    // Endpoint accessible by TEACHER and ADMIN
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('TEACHER') or hasRole('ADMIN')")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }

    // Endpoint accessible by STUDENT, TEACHER, and ADMIN
    @GetMapping("/filter")
    @PreAuthorize("hasRole('STUDENT') or hasRole('TEACHER') or hasRole('ADMIN')")
    public List<Course> filterCoursesByInstructor(@RequestParam String instructor) {
        return courseService.filterCoursesByInstructor(instructor);
    }

    // New endpoint for getting course content
    @GetMapping("/{id}/contents")
    @PreAuthorize("hasRole('STUDENT') or hasRole('TEACHER') or hasRole('ADMIN')")
    public List<Content> getCourseContents(@PathVariable Long id) {
        return courseService.getCourseContents(id);
    }

    // New endpoint for getting course quizzes
    @GetMapping("/{id}/quizzes")
    @PreAuthorize("hasRole('STUDENT') or hasRole('TEACHER') or hasRole('ADMIN')")
    public List<Quiz> getCourseQuizzes(@PathVariable Long id) {
        return courseService.getCourseQuizzes(id);
    }
}
