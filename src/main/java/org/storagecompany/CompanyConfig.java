package org.storagecompany;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompanyConfig {

    @Bean
    public Worker mishka() {
        return new Worker("Мишка");
    }

    @Bean
    public Worker zelya() {
        return new Worker("Зеля");
    }

    @Bean
    public Buyer petrovich() {
        return new Buyer("Петрович");
    }

    @Bean
    public Buyer reshar() {
        return new Buyer("Решар");
    }
}

