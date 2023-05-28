package com.example.springboot.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<UserEntity> findById(Integer id) {
        return this.userRepository.findById(id);
    }

    public Optional<UserEntity> findByLogin(String login) {
        return this.userRepository.findByLogin(login);
    }

    public List<UserEntity> searchBy(String login) {
        return this.userRepository.findAllByLoginContaining(login);
    }

    public List<UserEntity> searchBy(String login, int page, int pageSize, Sort sort) {
        return this.userRepository.findAllByLoginContaining(login, PageRequest.of(page, pageSize, sort == null ? Sort.unsorted() : sort));
    }

    public Page<UserEntity> searchBy(int page, int pageSize, Sort sort) {
        return this.userRepository.findAll(PageRequest.of(page, pageSize, sort == null? Sort.unsorted():sort));
    }



    public UserEntity create(UserEntity entity, String password) {
        entity.setPassword(password);
        entity.setCreatedAt(Instant.now());
        this.userRepository.save(entity);
        throw new IllegalArgumentException();
    }
}
