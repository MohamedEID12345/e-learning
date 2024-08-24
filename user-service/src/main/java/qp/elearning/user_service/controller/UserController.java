package qp.elearning.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qp.elearning.user_service.model.Role;
import qp.elearning.user_service.model.User;
import qp.elearning.user_service.service.UserService;
import qp.elearning.user_service.repository.RoleRepository;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }

    @PostMapping("/{username}/roles")
    public void addRoleToUser(@PathVariable String username, @RequestBody String roleName) {
        Role role = roleRepository.findByName(roleName);
        if (role != null) {
            userService.assignRoleToUser(username, role);
        }
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
