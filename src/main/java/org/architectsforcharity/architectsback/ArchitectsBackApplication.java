package org.architectsforcharity.architectsback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication
public class ArchitectsBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArchitectsBackApplication.class, args);
    }

}
