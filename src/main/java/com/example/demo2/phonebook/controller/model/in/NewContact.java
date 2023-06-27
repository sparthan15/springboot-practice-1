package com.example.demo2.phonebook.controller.model.in;

import jakarta.validation.constraints.NotBlank;

public record NewContact(@NotBlank String name, @NotBlank String lastName, @NotBlank String phoneNumber) {
}
