package com.example.demo2.phonebook.repository;

import com.example.demo2.phonebook.entity.PhonebookEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomizedPhonebookRepository extends BaseRepository<PhonebookEntity, Long> {
    List<PhonebookEntity> findAll();
}
