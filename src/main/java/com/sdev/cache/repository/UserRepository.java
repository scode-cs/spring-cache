package com.sdev.cache.repository;

import com.sdev.cache.model.UserRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserRepository {

    private List<UserRecord> users = new ArrayList<>();

    public UserRepository() {
        users.add(new UserRecord(1, "User One"));
        users.add(new UserRecord(2, "User Two"));
        users.add(new UserRecord(3, "User Three"));
        users.add(new UserRecord(4, "User Four"));
        users.add(new UserRecord(5, "User Five"));
        users.add(new UserRecord(6, "User Six"));
    }

    public List<UserRecord> fetchAll() {
        log.info("All the records are fetched from the Repository!!");
        return users;
    }


    public Optional<UserRecord> fetch(Integer id) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Record (ID - {}) fetched from the Repository!!", id);
        return filterUserById(id);
    }

    public UserRecord save(String userName) {
        var userRecord = new UserRecord(users.size(), userName);
        users.add(userRecord);
        log.info("Record saved at the Repository, Id: {}", userRecord.id());
        return userRecord;
    }

    public UserRecord update(UserRecord userRecord) {
        var status = deleteUserById(userRecord.id());
        if (Boolean.TRUE.equals(status)) {
            users.add(userRecord);
            log.info("Record updated at the Repository, Id: {}", userRecord.id());
        }
        return userRecord;
    }

    public Boolean delete(Integer id) {
        log.info("Record (ID - {}) fetched from the Repository!!", id);
        return deleteUserById(id);
    }

    private Optional<UserRecord> filterUserById(Integer id) {
        return users.stream().filter(usr -> id.equals(usr.id())).findFirst();
    }

    private Boolean deleteUserById(Integer id) {
        return users.removeIf(usr -> id.equals(usr.id()));
    }
}
