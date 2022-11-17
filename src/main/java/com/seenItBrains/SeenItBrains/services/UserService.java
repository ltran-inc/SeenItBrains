package com.seenItBrains.SeenItBrains.services;

import com.seenItBrains.SeenItBrains.domain.User;
import com.seenItBrains.SeenItBrains.exceptions.EtAuthException;

public interface UserService {

    User validateUser(String email, String password) throws EtAuthException;

    User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;
}
