package com.seenItBrains.SeenItBrains.resources;

import com.seenItBrains.SeenItBrains.model.SocialPost;
import com.seenItBrains.SeenItBrains.services.SocialPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/socialMedia")
public class SocialPostResource {

    @Autowired
    SocialPostService socialPostService;

    @GetMapping("all")
    public ResponseEntity<List<SocialPost>> getAllSocialPost() {
        List<SocialPost> socialPosts = socialPostService.fetchAllPost();
        return new ResponseEntity<>(socialPosts, HttpStatus.OK);
    }

    @GetMapping("/byId/{socialPostId}")
    public ResponseEntity<SocialPost> getSocialPostById(HttpServletRequest request, @PathVariable("socialPostId") Long socialPostId) {
        SocialPost socialPost = socialPostService.fetchPostById(socialPostId);
        return new ResponseEntity<>(socialPost, HttpStatus.OK);
    }

    @GetMapping("/byUserId/{userId}")
    public ResponseEntity<List<SocialPost>> getSocialPostByUserId(HttpServletRequest request, @PathVariable("userId") Long userId) {
        List<SocialPost> socialPosts = socialPostService.fetchAllPostByUserId(userId);
        return new ResponseEntity<>(socialPosts, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<SocialPost> addSocialPost(HttpServletRequest request, @RequestBody Map<String, Object> socialPostMap) {
        long userId = (Integer) request.getAttribute("userId");
        String content = (String) socialPostMap.get("content");
        SocialPost socialPost = socialPostService.addSocialPost(content, userId);
        return new ResponseEntity<>(socialPost, HttpStatus.CREATED);
    }

}
