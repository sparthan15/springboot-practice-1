package com.example.demo2.phonebook.config;

import com.example.demo2.phonebook.repository.PhonebookRepository;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationMetricsConfiguration {

    @Bean
    public Counter createContactCounter(MeterRegistry meterRegistry) {
        return Counter.builder("api.phonebook.contacts.created.count")
                .description("Total number of contacts ccreated")
                .register(meterRegistry);
    }

    @Bean
    public Gauge contactsCreatedGauge(MeterRegistry meterRegistry, PhonebookRepository phonebookRepository) {
        return Gauge.builder("api.phonebook.contacts.created.gauge", phonebookRepository::count)
                .description("Total number of contacts created")
                .register(meterRegistry);
    }
}
