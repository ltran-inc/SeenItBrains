package com.seenItBrains.SeenItBrains.services;

import com.seenItBrains.SeenItBrains.exceptions.EtAuthException;
import com.seenItBrains.SeenItBrains.model.User;
import com.seenItBrains.SeenItBrains.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User validateUser(String email, String password) throws EtAuthException {
        if (email != null)
            email = email.toLowerCase();
        User user = userRepository.findByEmail(email);
        if (user != null)
            return user;
        if (!BCrypt.checkpw(password, user.getPassword()))
            throw new EtAuthException("Invalid email/password");
        throw new EtAuthException("Could not find user");

    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException {

        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if (email != null)
            email = email.toLowerCase();
        if (!pattern.matcher(email).matches())
            throw new EtAuthException("Invalid email format");
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));
        Integer count = userRepository.getCountByEmail(email);
        if (count > 0)
            throw new EtAuthException("Email already in use !!!");

        User user = new User(firstName, lastName, email, hashedPassword);
        user = userRepository.save(user);
        return user;
    }

    @Override
    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }


}
