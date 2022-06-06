package com.sdev.cache.controller;

import com.sdev.cache.controller.response.StatusResponse;
import com.sdev.cache.model.UserNameRecord;
import com.sdev.cache.model.UserRecord;
import com.sdev.cache.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cache")
public record UserController(UserService userService) {

    @GetMapping("/v1/fetch")
    public List<UserRecord> fetchRecords() {
        return userService.getUsers();
    }

    @GetMapping("/v1/fetch/{id}")
    public UserRecord fetchRecord(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    @PostMapping("/v1/store")
    public UserRecord storeRecord(@RequestBody UserNameRecord nameRecord) {
        return userService.saveUser(nameRecord);
    }

    @PutMapping("/v1/update")
    public UserRecord updateRecord(@RequestBody UserRecord userRecord) {
        return userService.updateUser(userRecord);
    }

    @DeleteMapping("/v1/delete/{id}")
    public StatusResponse deleteRecord(@PathVariable Integer id) {
        var resp = userService.deleteUser(id);
        return Boolean.TRUE.equals(resp) ? new StatusResponse("SUCCESS") : new StatusResponse("FAIL");
    }


}
