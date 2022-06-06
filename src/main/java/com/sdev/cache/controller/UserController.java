package com.sdev.cache.controller;

import com.sdev.cache.model.UserRecord;
import com.sdev.cache.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cache")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/v1/fetch")
    public UserRecord fetchRecord() {
        return null;
    }

    @PostMapping("/v1/store")
    public void storeRecord() {

    }

    @PutMapping("/v1/update")
    public void updateRecord() {

    }

    @DeleteMapping("/v1/fetch")
    public void deleteRecord() {

    }


}
