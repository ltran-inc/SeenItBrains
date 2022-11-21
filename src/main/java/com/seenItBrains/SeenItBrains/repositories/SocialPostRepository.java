package com.seenItBrains.SeenItBrains.repositories;

import com.seenItBrains.SeenItBrains.domain.SocialPost;
import com.seenItBrains.SeenItBrains.exceptions.EtBadRequestException;
import com.seenItBrains.SeenItBrains.exceptions.EtResourceNotFoundException;

import java.util.List;

public interface SocialPostRepository {

    List<SocialPost> findAllPost() throws EtBadRequestException;

    List<SocialPost> findPostByUserId(Integer userId) throws EtResourceNotFoundException;

    SocialPost findPostById (Integer postId) throws EtResourceNotFoundException;

    Integer create (String content, Integer userId) throws EtBadRequestException;

}
