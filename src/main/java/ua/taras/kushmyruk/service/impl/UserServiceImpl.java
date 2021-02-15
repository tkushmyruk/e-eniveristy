package ua.taras.kushmyruk.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.taras.kushmyruk.model.User;
import ua.taras.kushmyruk.model.UserRole;
import ua.taras.kushmyruk.repository.UserRepository;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username) ;
    }

    public List<User> findAll() { return userRepository.findAll(); }

    public boolean addUser(String username, String password, String email) {
       User userFromDb = userRepository.findByUsername(username);
         if(userFromDb != null && username.isEmpty()){
             return false;
         }
         User user  = new User();
         user.setUsername(username);
         user.setPassword(password);
         user.setEmail(email);
         user.setActive(true);
         user.setUserRoles(Collections.singleton(UserRole.ADMIN));
         userRepository.save(user);
         return true;
    }

}

