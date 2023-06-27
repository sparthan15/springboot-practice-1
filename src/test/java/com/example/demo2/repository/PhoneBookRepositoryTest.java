package com.example.demo2.repository;

import com.example.demo2.phonebook.entity.PhonebookEntity;
import com.example.demo2.phonebook.repository.PhonebookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class PhoneBookRepositoryTest {

    @Autowired
    private PhonebookRepository phonebookRepository;

    @Test
    void testSavePhoneBook(){
        PhonebookEntity newContact = phonebookRepository.save(new PhonebookEntity("Carlie", "Gamboa", "123123"));
        Assertions.assertNotNull(newContact);
        Assertions.assertTrue(phonebookRepository.findAll().size()>0);
    }

    @Test
    void testDeletePhoneBook(){
        PhonebookEntity newContact = phonebookRepository.save(new PhonebookEntity("Carlie", "Gamboa", "123123"));
        phonebookRepository.delete(newContact);
        Assertions.assertTrue(phonebookRepository.findAll().isEmpty());
    }
}
