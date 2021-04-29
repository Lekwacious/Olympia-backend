package com.lekwacious.olympia.service;

import com.lekwacious.olympia.data.models.User;
import com.lekwacious.olympia.data.payloads.request.Profile;
import com.lekwacious.olympia.data.payloads.response.UserProfile;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User updateProfile(Profile profile);
}
