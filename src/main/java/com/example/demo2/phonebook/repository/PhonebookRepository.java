package com.example.demo2.phonebook.repository;

import com.example.demo2.phonebook.entity.PhonebookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhonebookRepository extends CrudRepository<PhonebookEntity, Long> {
    List<PhonebookEntity> findAll();
}
