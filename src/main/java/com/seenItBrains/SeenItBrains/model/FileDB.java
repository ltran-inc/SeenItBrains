package com.seenItBrains.SeenItBrains.model;

import javax.persistence.*;

import com.seenItBrains.SeenItBrains.model.SocialPost;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "files")
public class FileDB {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;

    private String type;

    @Lob
    private byte[] data;


//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "social_post_id")
//    private SocialPost socialPost;

    public FileDB() {
    }

    public FileDB(String name, String type, byte[] data, SocialPost socialPost) {
        this.name = name;
        this.type = type;
        this.data = data;
//        this.socialPost = socialPost;
    }

//    public SocialPost getSocialPost() {
//        return socialPost;
//    }

//    public void setSocialPost(SocialPost socialPost) {
//        this.socialPost = socialPost;
//    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

}
