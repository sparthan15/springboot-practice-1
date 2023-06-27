package com.example.demo2.phonebook.service;

import com.example.demo2.phonebook.entity.PhonebookEntity;
import com.example.demo2.phonebook.repository.PhonebookRepository;
import com.example.demo2.phonebook.service.dto.PhonebookDto;
import io.micrometer.core.instrument.Counter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PhonebookService implements PhonebookUseCases {


    private final PhonebookRepository phonebookRepository;

    private final Counter createContactCounter;

    @Override
    public boolean save(PhonebookDto phonebookDto) {
        createContactCounter.increment();
        Function<PhonebookDto, PhonebookEntity> entityFunction = p -> new PhonebookEntity(p.name(), p.lastName(), p.phoneNumber());
        return Objects.nonNull(phonebookRepository.save(entityFunction.apply(phonebookDto)));
    }

    @Override
    public List<PhonebookDto> findAllMyContacts() {

        return phonebookRepository.findAll().stream()
                .map(entity -> new PhonebookDto(entity.getId(),
                        entity.getName(),
                        entity.getLastName(),
                        entity.getPhoneNumber()))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(long id) {
        phonebookRepository.deleteById(id);
    }
}
