package com.lekwacious.olympia.service;

import com.lekwacious.olympia.data.models.User;
import com.lekwacious.olympia.data.payloads.request.Profile;
import com.lekwacious.olympia.data.payloads.response.UserProfile;
import com.lekwacious.olympia.data.repository.UserRepository;
import com.lekwacious.olympia.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateProfile(Profile profile) {
        User updatedUser = userRepository.findUserByEmail(profile.getEmail()).orElse(null);
        if (updatedUser != null){
            updatedUser.setFirstName(profile.getFirstName());
            updatedUser.setLastName(profile.getLastName());
            userRepository.save(updatedUser);

        }

        return updatedUser;
    }
}
