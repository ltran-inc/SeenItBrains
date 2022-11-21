package com.seenItBrains.SeenItBrains.services;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import com.seenItBrains.SeenItBrains.model.FileDB;
import com.seenItBrains.SeenItBrains.repositories.FileDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;



@Service
public class FileStorageService {

    @Autowired
    private FileDBRepository fileDBRepository;

    @Autowired
    private SocialPostService socialPostService;

    public FileDB store(MultipartFile file, Long publicationId) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes(), socialPostService.fetchPostById(publicationId));
        return fileDBRepository.save(FileDB);
    }

    public FileDB getFile(String id) {
        return fileDBRepository.findById(id).get();
    }

    public Stream<FileDB> getFileByPublicationId(Integer id) {
        return null;
//        return fileDBRepository.findByPublicationId(id).stream();
    }

    public Stream<FileDB> getAllFiles() {
        return fileDBRepository.findAll().stream();
    }
}