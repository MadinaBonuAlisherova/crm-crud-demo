package com.crm.crud.demo.Customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Column;
import java.util.Arrays;
import java.util.List;

@Configuration
public class CustomerConfig {

    @Bean  //to access to our repository
    CommandLineRunner commandLineRunner( CustomerRepository customerRepository){
        CommandLineRunner commandLineRunner = args -> {
            Customer bonu = new Customer(
                    "Bonu",
                    "single",
                    "bonu@kpi.com",
                    "99xxxxxxxxxx",
                    " Tashkent str",
                    "A dddlk",
                    "Ab4938435"
            );
            Customer valisher = new Customer(
                    "Valisher",
                    "single",
                    "valisher@kpi.com",
                    "99xxxxxxxxxx",
                    " Tashkent str 9",
                    "A kkkdb",
                    "Ab5345456"
            );

            customerRepository.saveAll(
                    Arrays.asList(bonu, valisher)
            );
        };
        return commandLineRunner;
    }
}
