package qp.elearning.course_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qp.elearning.course_service.model.Content;
import qp.elearning.course_service.service.ContentService;

import java.util.List;

@RestController
@RequestMapping("/api/contents")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @PostMapping
    public ResponseEntity<Content> createContent(@RequestBody Content content) {
        return ResponseEntity.ok(contentService.createContent(content));
    }

    @GetMapping
    public ResponseEntity<List<Content>> getAllContents() {
        return ResponseEntity.ok(contentService.getAllContents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Content> getContentById(@PathVariable Long id) {
        Content content = contentService.getContentById(id);
        return ResponseEntity.ok(content);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Content> updateContent(@PathVariable Long id, @RequestBody Content content) {
        Content updatedContent = contentService.updateContent(id, content);
        return ResponseEntity.ok(updatedContent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContent(@PathVariable Long id) {
        contentService.deleteContent(id);
        return ResponseEntity.noContent().build();
    }
}
