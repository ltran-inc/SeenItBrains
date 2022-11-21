//package com.seenItBrains.SeenItBrains.model;
//
//
//import com.seenItBrains.SeenItBrains.domain.User;
//import org.hibernate.annotations.GenericGenerator;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "SocialMediaPost")
//public class SocialMediaPost {
//
//    @Id
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
//    private String id;
//
//    private String content;
//
//
//
//
//
//    @OneToOne
//    @JoinColumn(name = "file_db_id")
//    private FileDB fileDB;
//
//    public FileDB getFileDB() {
//        return fileDB;
//    }
//
//    public void setFileDB(FileDB fileDB) {
//        this.fileDB = fileDB;
//    }
//
//
//
//
//
//
//}
