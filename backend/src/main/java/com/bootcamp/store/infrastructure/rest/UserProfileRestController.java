package com.bootcamp.store.infrastructure.rest;

import com.bootcamp.store.application.dto.CategoryDTO;
import com.bootcamp.store.application.dto.ItemDTO;
import com.bootcamp.store.application.dto.UserAuthDTO;
import com.bootcamp.store.application.dto.UserProfileDTO;
import com.bootcamp.store.application.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserProfileRestController {

    private UserProfileService userProfileService;

    @Autowired
    public UserProfileRestController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @CrossOrigin
    @GetMapping(value = "/users", produces = "application/json")
    ResponseEntity<List<UserProfileDTO>> getAllUsers() {
        List<UserProfileDTO> users = this.userProfileService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/users/{username}", produces = "application/json")
    ResponseEntity<UserProfileDTO> getUserByUsername(@PathVariable String username) {
        Optional<UserProfileDTO> user = this.userProfileService.getUserByUsername(username);

        if (user.isPresent()) return new ResponseEntity<>(user.get(), HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @PostMapping(value = "/users", produces = "application/json", consumes = "application/json")
    ResponseEntity<UserProfileDTO> insertUser(@RequestBody UserProfileDTO userProfileDTO) {
        Optional<UserProfileDTO> userProfileOptDTO = this.userProfileService.saveUserProfile(userProfileDTO);
        if (userProfileOptDTO.isPresent()) return new ResponseEntity<>(userProfileDTO, HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @CrossOrigin
    @PostMapping(value = "/users/authenticate", produces = "application/json", consumes = "application/json")
    ResponseEntity<UserProfileDTO> authenticateUser(@RequestBody UserAuthDTO userAuthDTO) {
        Optional<UserProfileDTO> userProfileDTO = this.userProfileService.authenticateUser(userAuthDTO);

        if (userProfileDTO.isPresent()) return new ResponseEntity<>(userProfileDTO.get(), HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    @CrossOrigin
    @PatchMapping(value = "/users/{userId}/favourites/{itemId}")
    ResponseEntity<UserProfileDTO> addFavouriteItem(@PathVariable Long userId, @PathVariable Long itemId) {
        UserProfileDTO userProfileDTO = this.userProfileService.addFavouriteItem(userId, itemId);

        if (userProfileDTO != null) return new ResponseEntity<>(userProfileDTO, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

}
