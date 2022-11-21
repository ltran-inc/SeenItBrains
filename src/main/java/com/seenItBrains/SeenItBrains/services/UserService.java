package com.seenItBrains.SeenItBrains.services;

import com.seenItBrains.SeenItBrains.exceptions.EtAuthException;
import com.seenItBrains.SeenItBrains.model.User;

import java.util.Optional;

public interface UserService {

    User validateUser(String email, String password) throws EtAuthException;

    User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;

    Optional<User> findById(Long userId);


}
