package com.example.users_service.infrastructure.persistence;

import com.example.users_service.domain.model.User;
import com.example.users_service.domain.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    // Constructor explícito en lugar de @RequiredArgsConstructor
    public UserRepositoryImpl(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    private User mapToDomain(UserEntity entity) {
        User user = new User();
        user.setId(entity.getId());
        user.setFirstName(entity.getFirstName());
        user.setLastName(entity.getLastName());
        user.setShippingAddress(entity.getShippingAddress());
        user.setEmail(entity.getEmail());
        user.setBirthDate(entity.getBirthDate());
        user.setPassword(entity.getPassword());
        return user;
    }

    private UserEntity mapToEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setShippingAddress(user.getShippingAddress());
        entity.setEmail(user.getEmail());
        entity.setBirthDate(user.getBirthDate());
        entity.setPassword(user.getPassword());
        return entity;
    }

    @Override
    public User save(User user) {
        UserEntity entity = mapToEntity(user);
        UserEntity saved = jpaUserRepository.save(entity);
        return mapToDomain(saved);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaUserRepository.findByEmail(email).map(this::mapToDomain);
    }

    @Override
    public User update(User user) {
        UserEntity entity = mapToEntity(user);
        UserEntity updated = jpaUserRepository.save(entity);
        return mapToDomain(updated);
    }
}
