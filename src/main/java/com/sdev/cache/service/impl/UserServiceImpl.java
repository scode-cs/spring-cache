package com.sdev.cache.service.impl;

import com.sdev.cache.model.UserNameRecord;
import com.sdev.cache.model.UserRecord;
import com.sdev.cache.repository.UserRepository;
import com.sdev.cache.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Cacheable(cacheNames = "users", key = "#id")
    public UserRecord getUser(Integer id) {
        return userRepository.fetch(id).orElse(new UserRecord(id, "Record NOT FOUND!!"));
    }

    @Override
    public List<UserRecord> getUsers() {
        return userRepository.fetchAll();
    }

    @Override
    @CachePut(cacheNames = "users", key = "#userRecord.id")
    public UserRecord saveUser(UserNameRecord userName) {
        return userRepository.save(userName.name());
    }

    @Override
    @CachePut(cacheNames = "users", key = "#userRecord.id")
    public UserRecord updateUser(UserRecord userRecord) {
        return userRepository.update(userRecord);
    }

    @Override
    @CacheEvict(cacheNames = "users", key = "#id")
    public Boolean deleteUser(Integer id) {
        return userRepository.delete(id);
    }
}
