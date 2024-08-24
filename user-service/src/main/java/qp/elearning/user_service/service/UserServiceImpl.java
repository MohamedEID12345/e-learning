package qp.elearning.user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import qp.elearning.user_service.dto.UserRegisterDTO;
import qp.elearning.user_service.dto.UserLoginDTO;
import qp.elearning.user_service.dto.UserResponseDTO;
import qp.elearning.user_service.model.User;
import qp.elearning.user_service.model.Role;
import qp.elearning.user_service.repository.UserRepository;
import qp.elearning.user_service.repository.RoleRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDTO registerUser(UserRegisterDTO userRegisterDTO) {
        User user = new User();
        user.setUsername(userRegisterDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        Set<Role> roles = userRegisterDTO.getRoles().stream()
                .map(roleName -> roleRepository.findByName(roleName))
                .collect(Collectors.toSet());

        if (roles.isEmpty()) {
            Role defaultRole = roleRepository.findByName("ROLE_STUDENT");
            if (defaultRole == null) {
                defaultRole = new Role();
                defaultRole.setName("ROLE_STUDENT");
                roleRepository.save(defaultRole);
            }
            roles.add(defaultRole);
        }

        user.setRoles(roles);
        User savedUser = userRepository.save(user);

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(savedUser.getId());
        userResponseDTO.setUsername(savedUser.getUsername());
        userResponseDTO.setRoles(savedUser.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toSet()));

        return userResponseDTO;
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void assignRoleToUser(String username, Role role) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            user.getRoles().add(role);
            userRepository.save(user);
        }
    }

    @Override
    public String loginUser(UserLoginDTO userLoginDTO) {
        // هنا يتم التحقق من صحة بيانات تسجيل الدخول وإنشاء التوكن JWT
        return "token";
    }
}
