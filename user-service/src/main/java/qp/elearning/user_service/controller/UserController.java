package qp.elearning.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qp.elearning.user_service.dto.UserRegisterDTO;
import qp.elearning.user_service.dto.UserLoginDTO;
import qp.elearning.user_service.dto.UserResponseDTO;
import qp.elearning.user_service.model.User;
import qp.elearning.user_service.model.Role;
import qp.elearning.user_service.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRegisterDTO userRegisterDTO) {
        UserResponseDTO userResponseDTO = userService.registerUser(userRegisterDTO);
        return ResponseEntity.ok(userResponseDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserLoginDTO userLoginDTO) {
        String token = userService.loginUser(userLoginDTO);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/{username}/roles")
    public ResponseEntity<Void> assignRoleToUser(@PathVariable String username, @RequestBody Role role) {
        userService.assignRoleToUser(username, role);
        return ResponseEntity.noContent().build();
    }
}
