package com.lekwacious.olympia.web;

import com.lekwacious.olympia.data.models.User;
import com.lekwacious.olympia.data.payloads.request.Profile;
import com.lekwacious.olympia.data.payloads.response.UserIdentityAvailability;
import com.lekwacious.olympia.data.payloads.response.UserProfile;
import com.lekwacious.olympia.data.payloads.response.UserSummary;
import com.lekwacious.olympia.data.repository.UserRepository;
import com.lekwacious.olympia.security.CurrentUser;
import com.lekwacious.olympia.service.UserService;
import com.lekwacious.olympia.service.exception.ResourceNotFoundException;
import com.lekwacious.olympia.security.UserPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/")
public class UserController {



    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserService userService;


    @GetMapping("user/me")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser){
        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getFirstName(), currentUser.getLastName());
        return userSummary;
    }


    @GetMapping("/user/checkEmailAvailability")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam("email") String email){
        Boolean isAvailable =! userRepository.existsByEmail(email);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/users/{email}")
    public UserProfile getUserProfile(@PathVariable(value = "email") String email){
        User user = userRepository.findUserByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("User","username", email));

        return new UserProfile(user.getId(), user.getLastName(), user.getFirstName(), user.getLastName());
    }
    @GetMapping("/users/")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }
    @PatchMapping("/update-profile/")
    public User updateProfile(@RequestBody Profile profile){
        return userService.updateProfile(profile);
    }






}
