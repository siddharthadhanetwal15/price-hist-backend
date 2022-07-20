package com.md;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class PriceHistBackendApplicationTest {
    public static void main(String[] args) {
        SpringApplication.run(PriceHistBackendApplicationTest.class, args);
    }
}
