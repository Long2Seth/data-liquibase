package co.istad.databasewithjpa.controller;


import co.istad.databasewithjpa.dto.UserRequest;
import co.istad.databasewithjpa.dto.UserResponse;
import co.istad.databasewithjpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public void createUser(UserRequest userRequest){
        userService.createUser(userRequest);
    }


}
