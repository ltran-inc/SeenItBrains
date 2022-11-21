package com.seenItBrains.SeenItBrains.services;

import com.seenItBrains.SeenItBrains.model.SocialPost;
import com.seenItBrains.SeenItBrains.exceptions.EtBadRequestException;
import com.seenItBrains.SeenItBrains.exceptions.EtResourceNotFoundException;

import java.util.List;

public interface SocialPostService {

    List<SocialPost> fetchAllPost() throws EtBadRequestException;

    List<SocialPost> fetchAllPostByUserId(Long userId) throws EtResourceNotFoundException;

    SocialPost fetchPostById (Long postId) throws EtResourceNotFoundException;

    SocialPost addSocialPost (String content, Long userId) throws EtBadRequestException, EtResourceNotFoundException;

}
