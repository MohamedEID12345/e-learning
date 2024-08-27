package qp.elearning.course_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qp.elearning.course_service.exception.ResourceNotFoundException;
import qp.elearning.course_service.model.Content;
import qp.elearning.course_service.repository.ContentRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;

    public Content createContent(Content content) {
        return contentRepository.save(content);
    }

    public List<Content> getAllContents() {
        return contentRepository.findAll();
    }

    public Content getContentById(Long id) {
        return contentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Content not found with id " + id));
    }

    public Content updateContent(Long id, Content content) {
        if (contentRepository.existsById(id)) {
            content.setId(id);
            return contentRepository.save(content);
        }
        throw new ResourceNotFoundException("Content not found with id " + id);
    }

    public void deleteContent(Long id) {
        if (contentRepository.existsById(id)) {
            contentRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Content not found with id " + id);
        }
    }
}
