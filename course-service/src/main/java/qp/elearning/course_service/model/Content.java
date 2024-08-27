package qp.elearning.course_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Content type is required")
    private String type; // video, audio, pdf

    private String url;  // URL to the content (if source is URL)

    private String fileName; // Name of the file (if source is device)

    @NotBlank(message = "Source type is required")
    private String sourceType; // "url" or "device"

    @ManyToOne
    @JoinColumn(name = "course_id")
    @NotNull(message = "Course is required")
    private Course course;
}
