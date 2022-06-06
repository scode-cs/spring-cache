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
        log.info("Record (ID - {}) fetched from the Repository!!", id);
        return users.stream().filter(usr -> id.equals(usr.id())).findFirst();
    }

    public UserRecord save(String userName) {
        var userRecord = new UserRecord(users.size(), userName);
        users.add(userRecord);
        return userRecord;
    }

    public UserRecord update(UserRecord userRecord) {
        var status = delete(userRecord.id());
        if (Boolean.TRUE.equals(status)) {
            users.add(userRecord);
        }
        return userRecord;
    }

    public Boolean delete(Integer id) {
        var user = fetch(id);
        if (user.isPresent()) {
            users.remove(user);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}
