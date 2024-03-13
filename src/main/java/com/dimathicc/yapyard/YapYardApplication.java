package com.dimathicc.yapyard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class YapYardApplication {

    public static void main(String[] args) {
        SpringApplication.run(YapYardApplication.class, args);
    }

}
