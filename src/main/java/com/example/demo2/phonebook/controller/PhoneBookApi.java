package com.example.demo2.phonebook.controller;

import com.example.demo2.phonebook.controller.model.in.NewContact;
import com.example.demo2.phonebook.controller.model.out.Contact;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/phonebook/contacts")
public interface PhoneBookApi {

    @PostMapping
    boolean createContact(@RequestBody NewContact newContact);
    @GetMapping
    List<Contact> fetchAllContacts();
    @DeleteMapping
    void deleteContact(long contactId);
}
