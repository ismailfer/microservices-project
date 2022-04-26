package com.ismail.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class NotificationApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(NotificationApplication.class, args);
    }
}
