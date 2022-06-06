package com.sdev.cache.service.impl;

import com.sdev.cache.model.UserNameRecord;
import com.sdev.cache.model.UserRecord;
import com.sdev.cache.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserRecord getUser(Integer userId) {
        return null;
    }

    @Override
    public List<UserRecord> getUsers() {
        return null;
    }

    @Override
    public UserRecord saveUser(UserNameRecord userName) {
        return null;
    }

    @Override
    public UserRecord updateUser(UserRecord userRecord) {
        return null;
    }

    @Override
    public Boolean deleteUser(Integer userId) {
        return null;
    }
}
