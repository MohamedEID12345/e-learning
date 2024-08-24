package qp.elearning.user_service.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserResponseDTO {
    private Long id;
    private String username;
    private Set<String> roles;
}
