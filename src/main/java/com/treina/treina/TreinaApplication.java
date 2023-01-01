package com.treina.treina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TreinaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TreinaApplication.class, args);
        System.out.println(new BCryptPasswordEncoder().encode("1234"));
    }


}
