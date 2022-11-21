//package com.seenItBrains.SeenItBrains.repositories;
//
//import ch.qos.logback.core.util.InvocationGate;
//import com.seenItBrains.SeenItBrains.domain.SocialPost;
//import com.seenItBrains.SeenItBrains.exceptions.EtBadRequestException;
//import com.seenItBrains.SeenItBrains.exceptions.EtResourceNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.jdbc.support.KeyHolder;
//import org.springframework.stereotype.Repository;
//
//import java.sql.PreparedStatement;
//import java.sql.Statement;
//import java.sql.Timestamp;
//import java.util.List;
//
//@Repository
//public class SocialPostRepositoryImpl implements SocialPostRepository {
//
//    private static final String SQL_CREATE = "INSERT INTO et_social_post(SOCIAL_POST_ID, USER_ID, CONTENT, post_timestamp) VALUES(NEXTVAL('ET_SOCIAL_POST_SEQ'), ?, ?, ?)";
//
//    private static final String SQL_GET_ALL = "SELECT * FROM ET_SOCIAL_POST";
//
//    private static final String SQL_GET_BY_ID = "SELECT * FROM ET_SOCIAL_POST WHERE SOCIAL_POST_ID = ?";
//
//    private static final String SQL_GET_BY_USER_ID = "SELECT * FROM ET_SOCIAL_POST WHERE USER_ID = ?";
//
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    @Override
//    public List<SocialPost> findAllPost(){
//        return jdbcTemplate.query(SQL_GET_ALL, new Object[]{}, socialPostRowMapper);
//    }
//
//    @Override
//    public List<SocialPost> findPostByUserId(Integer userId) {
//        return jdbcTemplate.query(SQL_GET_BY_USER_ID, new Object[]{userId}, socialPostRowMapper);
//    }
//
//    @Override
//    public SocialPost findPostById(Integer postId) throws EtResourceNotFoundException {
//        try {
//            return jdbcTemplate.queryForObject(SQL_GET_BY_ID, new Object[]{postId}, socialPostRowMapper);
//        } catch (Exception e) {
//            throw new EtResourceNotFoundException("could not find this post");
//        }
//    }
//
////    @Override
////    public Integer create(String content, Integer userId) throws EtBadRequestException {
////        try {
////            KeyHolder keyHolder = new GeneratedKeyHolder();
////            jdbcTemplate.update(connection -> {
////                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
////                ps.setInt(1, userId);
////                ps.setString(2, content);
////                ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
////
////                return ps;
////            }, keyHolder);
////            return (Integer) keyHolder.getKeys().get("SOCIAL_POST_ID");
////        } catch (Exception e) {
////            throw new EtBadRequestException("Invalid request " + e);
////        }
////    }
//
//    private RowMapper<SocialPost> socialPostRowMapper = ((rs, rowNum) -> {
//        return new SocialPost(
//                rs.getInt("SOCIAL_POST_ID"),
//                rs.getInt("USER_ID"),
//                rs.getString("CONTENT"),
//                rs.getTimestamp("POST_TIMESTAMP")
//        );
//    });
//}
