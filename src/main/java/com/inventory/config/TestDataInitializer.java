package com.inventory.config;

import com.inventory.model.*;
import com.inventory.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;

@Configuration
@RequiredArgsConstructor
public class TestDataInitializer {

    @Bean
    @Profile("!prod")
    public CommandLineRunner initializeData(
            PartyService partyService,
            DealerService dealerService) {
        return args -> {
            // Add test suppliers
            Party party1 = new Party();
            party1.setName("Supplier 1");
            party1.setSinNumber("SIN001");
            party1.setPhoneNumber("1234567890");
            partyService.saveParty(party1);

            Party party2 = new Party();
            party2.setName("Supplier 2");
            party2.setSinNumber("SIN002");
            party2.setPhoneNumber("9876543210");
            partyService.saveParty(party2);

            // Add test dealers
            Dealer dealer1 = new Dealer();
            dealer1.setName("Dealer 1");
            dealer1.setGstNumber("GST001");
            dealer1.setPhoneNumber("1111111111");
            dealer1.setAddress("Address 1");
            dealerService.saveDealer(dealer1);

            Dealer dealer2 = new Dealer();
            dealer2.setName("Dealer 2");
            dealer2.setGstNumber("GST002");
            dealer2.setPhoneNumber("2222222222");
            dealer2.setAddress("Address 2");
            dealerService.saveDealer(dealer2);
        };
    }
} 