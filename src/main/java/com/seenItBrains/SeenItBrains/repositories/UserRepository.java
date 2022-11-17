package com.seenItBrains.SeenItBrains.repositories;

import com.seenItBrains.SeenItBrains.domain.User;
import com.seenItBrains.SeenItBrains.exceptions.EtAuthException;

public interface UserRepository {

    Integer create(String firstName, String lastNAme, String email, String password) throws EtAuthException;

    User findByEmailAndPassword(String email, String password) throws EtAuthException;

    Integer getCountByEmail(String email);

    User findById(Integer userId);
}
