package com.lekwacious.olympia.security;

import com.lekwacious.olympia.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.lekwacious.olympia.data.models.User;

import com.lekwacious.olympia.security.UserPrincipal;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //Let people login with email
        User user = userRepository.findUserByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found with such email: ".concat(email)));
        return UserPrincipal.create(user);
    }
    @Transactional
    public UserDetails loadUserById(Integer id){
        User user = userRepository.findById(id).orElseThrow(()-> new UsernameNotFoundException("User notfound with iid: "+ id));
        return UserPrincipal.create(user);
    }
}
