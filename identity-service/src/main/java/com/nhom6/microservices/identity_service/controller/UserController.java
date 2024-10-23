package com.nhom6.microservices.identity_service.controller;

import com.nhom6.microservices.identity_service.dto.request.ApiResponse;
import com.nhom6.microservices.identity_service.dto.request.UserCreationRequest;
import com.nhom6.microservices.identity_service.dto.request.UserUpdateRequest;
import com.nhom6.microservices.identity_service.dto.respone.UserResponse;
import com.nhom6.microservices.identity_service.entity.User;
import com.nhom6.microservices.identity_service.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping
    public ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));
        return apiResponse;
    }
    @GetMapping
    public List<User> getAllUsers() {
        return  userService.getAllUsers();
    }
    @GetMapping("/{userid}")
    public UserResponse getUserById(@PathVariable String userid) {
        return userService.getUserById(userid);
    }
    @PutMapping("/{userid}")
    public UserResponse updateUser(@PathVariable String userid, @RequestBody UserUpdateRequest request)
    {
        return userService.updateUser(userid, request);
    }
    @DeleteMapping("/{userid}")
    public String deleteUser(@PathVariable String userid) {
        return userService.deleteUser(userid);
    }

}
