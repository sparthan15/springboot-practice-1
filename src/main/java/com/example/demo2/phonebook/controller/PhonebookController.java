package com.example.demo2.phonebook.controller;

import com.example.demo2.phonebook.controller.model.in.NewContact;
import com.example.demo2.phonebook.controller.model.out.Contact;
import com.example.demo2.phonebook.service.PhonebookUseCases;
import com.example.demo2.phonebook.service.dto.PhonebookDto;
import jakarta.validation.Valid;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PhonebookController implements PhoneBookApi {

    private final PhonebookUseCases phonebookUseCases;

    @Override
    public boolean createContact(@Valid NewContact newContact) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        validator.validate(newContact);
        Function<NewContact, PhonebookDto> phonebookDtoFunction =
                p -> new PhonebookDto(0L, p.name(), p.lastName(), p.phoneNumber());
        return phonebookUseCases.save(phonebookDtoFunction.apply(newContact));
    }

    @Override
    public List<Contact> fetchAllContacts() {
        return phonebookUseCases.findAllMyContacts()
                .stream().map(dto -> new Contact(dto.id(), dto.name(), dto.lastName(), dto.phoneNumber()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void deleteContact(long contactId) {
        phonebookUseCases.delete(contactId);
    }

}
