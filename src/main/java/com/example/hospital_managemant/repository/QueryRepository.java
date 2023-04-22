package com.example.hospital_managemant.repository;

import com.example.hospital_managemant.entity.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface QueryRepository extends JpaRepository<Query, Long> {
    @Transactional
    @Modifying
    @org.springframework.data.jpa.repository.Query("update Query q set q.status = ?1 where q.id = ?2")
    int updateStatusById(String status, Long id);
    @Transactional
    @Modifying
    @org.springframework.data.jpa.repository.Query("update Query q set q.replyText = ?1 where q.id = ?2")
    int updateReplyTextById(String replyText, Long id);
    @org.springframework.data.jpa.repository.Query("select q from Query q where q.status = ?1")
    List<Query> findByStatus(String status);
    @Transactional
    @Modifying
    @org.springframework.data.jpa.repository.Query("update Query q set q.replyText = ?1")
    int updateReplyTextBy(String replyText);
    @org.springframework.data.jpa.repository.Query("select q from Query q where q.subject = ?1")
    Query findBySubject(String subject);
}
