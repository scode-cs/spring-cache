package com.sdev.cache.controller;

import com.sdev.cache.controller.response.StatusResponse;
import com.sdev.cache.model.UserNameRecord;
import com.sdev.cache.model.UserRecord;
import com.sdev.cache.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cache")
public record UserController(UserService userService) {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/v1/fetch")
    public List<UserRecord> fetchRecords() {
        return userService.getUsers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/v1/fetch/{id}")
    public UserRecord fetchRecord(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/v1/store")
    public UserRecord storeRecord(@RequestBody UserNameRecord nameRecord) {
        return userService.saveUser(nameRecord);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/v1/update")
    public UserRecord updateRecord(@RequestBody UserRecord userRecord) {
        return userService.updateUser(userRecord);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/v1/delete/{id}")
    public StatusResponse deleteRecord(@PathVariable Integer id) {
        var resp = userService.deleteUser(id);
        return Boolean.TRUE.equals(resp) ? new StatusResponse("SUCCESS") : new StatusResponse("FAIL");
    }


}
