package com.seenItBrains.SeenItBrains.repositories;

import com.seenItBrains.SeenItBrains.exceptions.EtAuthException;
import com.seenItBrains.SeenItBrains.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u where u.email = ?1")
    User findByEmail(String email) throws EtAuthException;


    @Query("SELECT count(u) FROM User u where u.email = ?1")
    Integer getCountByEmail(String email);


}
