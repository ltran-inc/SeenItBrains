package com.seenItBrains.SeenItBrains.services;


import com.seenItBrains.SeenItBrains.exceptions.EtBadRequestException;
import com.seenItBrains.SeenItBrains.exceptions.EtResourceNotFoundException;
import com.seenItBrains.SeenItBrains.model.SocialPost;
import com.seenItBrains.SeenItBrains.model.User;
import com.seenItBrains.SeenItBrains.repositories.SocialPostRepository2Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SocialPostServiceImpl implements SocialPostService {

    @Autowired
    SocialPostRepository2Impl socialPostRepository;
    @Autowired
    UserService userService;

    @Override
    public List<SocialPost> fetchAllPost() {
        return socialPostRepository.findAll();

    }

    @Override
    public List<SocialPost> fetchAllPostByUserId(Long userId) {
        return socialPostRepository.findByUserId(userId);
    }

    @Override
    public SocialPost fetchPostById(Long postId) {
        return socialPostRepository.findById(postId).orElseThrow(() -> new EtResourceNotFoundException("Could not find post"));
    }

    @Override
    public SocialPost addSocialPost(String content, Long userId) {
        Optional<User> user = userService.findById(userId);

        if (user.isEmpty()) {
            throw new EtResourceNotFoundException("Could not find user");
        }

        SocialPost socialPost = new SocialPost(user.get(), content, new Timestamp(System.currentTimeMillis()));

        if (socialPost != socialPostRepository.save(socialPost))
            throw new EtBadRequestException("Could not post");
        return socialPost;
    }
}
