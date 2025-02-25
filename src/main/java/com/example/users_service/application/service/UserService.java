package com.example.users_service.application.service;

import com.example.users_service.application.dto.AuthResponseDTO;
import com.example.users_service.application.dto.UserLoginDTO;
import com.example.users_service.application.dto.UserProfileDTO;
import com.example.users_service.application.dto.UserRegistrationDTO;
import com.example.users_service.domain.model.User;
import com.example.users_service.domain.repository.UserRepository;
import com.example.users_service.infrastructure.config.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    // Constructor explícito en lugar de @RequiredArgsConstructor
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public void registerUser(UserRegistrationDTO registrationDTO) {
        // Check if user already exists
        Optional<User> existingUser = userRepository.findByEmail(registrationDTO.getEmail());
        if(existingUser.isPresent()){
            throw new RuntimeException("User already exists");
        }
        // Map DTO to domain model
        User user = new User();
        user.setFirstName(registrationDTO.getFirstName());
        user.setLastName(registrationDTO.getLastName());
        user.setShippingAddress(registrationDTO.getShippingAddress());
        user.setEmail(registrationDTO.getEmail());
        user.setBirthDate(registrationDTO.getBirthDate());
        // Encrypt password using BCrypt
        user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        userRepository.save(user);
    }

    public AuthResponseDTO authenticateUser(UserLoginDTO loginDTO) {
        Optional<User> userOpt = userRepository.findByEmail(loginDTO.getEmail());
        if(userOpt.isEmpty() || !passwordEncoder.matches(loginDTO.getPassword(), userOpt.get().getPassword())){
            throw new RuntimeException("Invalid credentials");
        }
        String token = jwtUtil.generateToken(userOpt.get());
        AuthResponseDTO response = new AuthResponseDTO();
        response.setToken(token);
        return response;
    }

    public UserProfileDTO getUserProfile(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        UserProfileDTO profile = new UserProfileDTO();
        profile.setId(user.getId());
        profile.setFirstName(user.getFirstName());
        profile.setLastName(user.getLastName());
        profile.setShippingAddress(user.getShippingAddress());
        profile.setEmail(user.getEmail());
        profile.setBirthDate(user.getBirthDate());
        return profile;
    }

    public UserProfileDTO updateUserProfile(String email, UserProfileDTO profileDTO) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        // Update fields from DTO
        user.setFirstName(profileDTO.getFirstName());
        user.setLastName(profileDTO.getLastName());
        user.setShippingAddress(profileDTO.getShippingAddress());
        user.setBirthDate(profileDTO.getBirthDate());
        User updatedUser = userRepository.update(user);
        UserProfileDTO updatedProfile = new UserProfileDTO();
        updatedProfile.setId(updatedUser.getId());
        updatedProfile.setFirstName(updatedUser.getFirstName());
        updatedProfile.setLastName(updatedUser.getLastName());
        updatedProfile.setShippingAddress(updatedUser.getShippingAddress());
        updatedProfile.setEmail(updatedUser.getEmail());
        updatedProfile.setBirthDate(updatedUser.getBirthDate());
        return updatedProfile;
    }
}
