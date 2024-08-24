package qp.elearning.user_service.service;

import qp.elearning.user_service.dto.UserRegisterDTO;
import qp.elearning.user_service.dto.UserLoginDTO;
import qp.elearning.user_service.dto.UserResponseDTO;
import qp.elearning.user_service.model.User;
import qp.elearning.user_service.model.Role;

public interface UserService {
    UserResponseDTO registerUser(UserRegisterDTO userRegisterDTO);
    User findUserByUsername(String username);
    void assignRoleToUser(String username, Role role);
    String loginUser(UserLoginDTO userLoginDTO);
}
