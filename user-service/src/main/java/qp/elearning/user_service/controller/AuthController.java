package qp.elearning.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qp.elearning.user_service.dto.UserRegisterDTO;
import qp.elearning.user_service.dto.UserLoginDTO;
import qp.elearning.user_service.dto.UserResponseDTO;
import qp.elearning.user_service.model.Role;
import qp.elearning.user_service.service.UserService;
import qp.elearning.user_service.repository.RoleRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/register")
    public UserResponseDTO registerUser(@RequestBody UserRegisterDTO userRegisterDTO) {
        return userService.registerUser(userRegisterDTO);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody UserLoginDTO userLoginDTO) {
        return userService.loginUser(userLoginDTO);
    }
}
