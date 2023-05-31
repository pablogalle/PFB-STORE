package com.bootcamp.store.infrastructure.rest;

import com.bootcamp.store.application.dto.UserProfileDTO;
import com.bootcamp.store.application.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserProfileRestController {

    private UserProfileService userProfileService;

    @Autowired
    public UserProfileRestController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @CrossOrigin
    @PostMapping(value = "/users", produces = "application/json", consumes = "application/json")
    ResponseEntity<UserProfileDTO> insertUser(@RequestBody UserProfileDTO userProfileDTO){
        userProfileDTO = this.userProfileService.saveUserProfile(userProfileDTO);
        return new ResponseEntity<>(userProfileDTO, HttpStatus.CREATED);
    }
}
