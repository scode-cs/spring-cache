package com.sdev.cache.service;

import com.sdev.cache.model.UserNameRecord;
import com.sdev.cache.model.UserRecord;

import java.util.List;


public interface UserService {

    public UserRecord getUser(Integer id);

    public List<UserRecord> getUsers();

    public UserRecord saveUser(UserNameRecord userName);

    public UserRecord updateUser(UserRecord userRecord);

    public Boolean deleteUser(Integer id);
}
