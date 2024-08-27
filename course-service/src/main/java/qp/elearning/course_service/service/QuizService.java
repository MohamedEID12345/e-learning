package qp.elearning.course_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qp.elearning.course_service.model.Quiz;
import qp.elearning.course_service.repository.QuizRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Optional<Quiz> getQuizById(Long id) {
        return quizRepository.findById(id);
    }

    public Quiz updateQuiz(Long id, Quiz quiz) {
        if (quizRepository.existsById(id)) {
            quiz.setId(id);
            return quizRepository.save(quiz);
        }
        return null;
    }

    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }
}
