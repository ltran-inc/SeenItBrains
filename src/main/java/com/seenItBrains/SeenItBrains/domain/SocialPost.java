package com.seenItBrains.SeenItBrains.domain;

import java.sql.Timestamp;

public class SocialPost {

    private Integer socialPostId;
    private Integer userId;
    private String content;
    private Timestamp postTimestamp;


    public SocialPost(Integer socialPostId, Integer userId, String content, Timestamp postTimestamp) {
        this.socialPostId = socialPostId;
        this.userId = userId;
        this.content = content;

        this.postTimestamp = postTimestamp;

    }



    public Integer getSocialPostId() {
        return socialPostId;
    }

    public void setSocialPostId(Integer socialPostId) {
        this.socialPostId = socialPostId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getPostTimestamp() {
        return postTimestamp;
    }

    public void setPostTimestamp(Timestamp postTimestamp) {
        this.postTimestamp = postTimestamp;
    }
}
