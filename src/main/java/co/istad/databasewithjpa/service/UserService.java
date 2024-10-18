package co.istad.databasewithjpa.service;


import co.istad.databasewithjpa.dto.UserRequest;
import co.istad.databasewithjpa.dto.UserResponse;
import co.istad.databasewithjpa.entities.Role;
import co.istad.databasewithjpa.entities.User;
import co.istad.databasewithjpa.repositories.RoleRepository;
import co.istad.databasewithjpa.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public void createUser(UserRequest userRequest){

        Role role = roleRepository.findByRoleName(userRequest.roleName())
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role not found")
                );

        User user = new User();

        user.setName(userRequest.username());
        user.setPassword(userRequest.password());
        user.setEmail(userRequest.email());
        user.setRoles(Collections.singletonList(role));

        userRepository.save(user);

    }

    public List<UserResponse> getAllUsers(){
        List<User> user = userRepository.findAll();

        return user.stream()
                .map
                        (
                                user1 -> new UserResponse(
                                        user1.getId(),
                                        user1.getName(),
                                        user1.getEmail(),
                                        user1.getRoles().stream().map(Role::getRoleName).toList()
                                )
                        ).toList();
    }
}
