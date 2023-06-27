package com.example.demo2.phonebook.service;

import com.example.demo2.phonebook.service.dto.PhonebookDto;

import java.util.List;

public interface PhonebookUseCases {

    boolean save(PhonebookDto phonebookDto);
    List<PhonebookDto> findAllMyContacts();
    void delete(long id);
}
