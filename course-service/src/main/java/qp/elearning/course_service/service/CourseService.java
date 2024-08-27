package qp.elearning.course_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qp.elearning.course_service.model.Content;
import qp.elearning.course_service.model.Course;
import qp.elearning.course_service.model.Quiz;
import qp.elearning.course_service.repository.ContentRepository;
import qp.elearning.course_service.repository.CourseRepository;
import qp.elearning.course_service.repository.QuizRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private QuizRepository quizRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Course updateCourse(Long id, Course course) {
        if (courseRepository.existsById(id)) {
            course.setId(id);
            return courseRepository.save(course);
        }
        return null;  // Or throw an exception indicating course not found
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public List<Course> filterCoursesByInstructor(String instructor) {
        return courseRepository.findByInstructor(instructor);
    }

    public List<Content> getCourseContents(Long courseId) {
        return contentRepository.findByCourseId(courseId);
    }

    public List<Quiz> getCourseQuizzes(Long courseId) {
        return quizRepository.findByCourseId(courseId);
    }
}
