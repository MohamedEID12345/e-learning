package qp.elearning.user_service.dto;



import lombok.Data;

import java.util.Set;

@Data
public class UserRegisterDTO {
    private String username;
    private String password;
    private Set<String> roles; // أدوار المستخدم مثل "ADMIN", "TEACHER", "STUDENT"
}
