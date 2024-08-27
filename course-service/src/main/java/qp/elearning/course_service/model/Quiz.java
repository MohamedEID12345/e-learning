package qp.elearning.course_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;
    private String correctAnswer;

    @ElementCollection
    private List<String> options;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
