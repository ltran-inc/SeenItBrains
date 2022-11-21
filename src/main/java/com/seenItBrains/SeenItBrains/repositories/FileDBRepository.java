package com.seenItBrains.SeenItBrains.repositories;

import com.seenItBrains.SeenItBrains.model.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
@Transactional
public interface FileDBRepository extends JpaRepository<FileDB, String> {
//    @Query("SELECT * FROM files where publicationId = :publicationId")
//    List<FileDB> findByPublicationId(@Param("publicationId") Integer publicationId);

//    @Query("SELECT r FROM FileDB r where r.publicationId = :pub")
//    List<FileDB> findByPublicationId(@Param("pub") Integer publicationId);
}
