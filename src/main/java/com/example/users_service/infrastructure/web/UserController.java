package com.example.users_service.infrastructure.web;

import com.example.users_service.application.dto.AuthResponseDTO;
import com.example.users_service.application.dto.UserLoginDTO;
import com.example.users_service.application.dto.UserProfileDTO;
import com.example.users_service.application.dto.UserRegistrationDTO;
import com.example.users_service.application.service.UserService;
import com.example.users_service.domain.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // Constructor explícito en lugar de @RequiredArgsConstructor
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationDTO registrationDTO) {
        userService.registerUser(registrationDTO);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> loginUser(@RequestBody UserLoginDTO loginDTO) {
        AuthResponseDTO authResponse = userService.authenticateUser(loginDTO);
        return ResponseEntity.ok(authResponse);
    }

    @GetMapping("/profile")
    public ResponseEntity<UserProfileDTO> getUserProfile(Authentication authentication) {
        String email = ((User) authentication.getPrincipal()).getEmail();
        UserProfileDTO profile = userService.getUserProfile(email);
        return ResponseEntity.ok(profile);
    }

    @PutMapping("/profile")
    public ResponseEntity<UserProfileDTO> updateUserProfile(
            Authentication authentication,
            @RequestBody UserProfileDTO profileDTO) {
        String email = ((User) authentication.getPrincipal()).getEmail();
        UserProfileDTO updatedProfile = userService.updateUserProfile(email, profileDTO);
        return ResponseEntity.ok(updatedProfile);
    }
}