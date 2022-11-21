package com.seenItBrains.SeenItBrains.repositories;

import com.seenItBrains.SeenItBrains.model.SocialPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface SocialPostRepository2Impl extends JpaRepository<SocialPost, Long> {

    @Query("SELECT u FROM SocialPost u where u.id = ?1")
    List<SocialPost> findByUserId(Long userId);
}
