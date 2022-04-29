package com.ismail.notification;

import com.ismail.amqp.RabbitMQMessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

// defining scanBasePackages; will allow us to inject dependencies from these packages
@SpringBootApplication(scanBasePackages = {"com.ismail.notification", "com.ismail.amqp"})
@EnableEurekaClient
@PropertySources({
        @PropertySource("classpath:clients-${spring.profiles.active}.properties")
}) // k8s properties
public class NotificationApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(NotificationApplication.class, args);

        /**
         * Test publishing a message to the notification queue
         */


    }

    /**
     * Bean annotation is used for injection

    @Bean
    CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer, NotificationConfig notificationConfig)
    {
        return args -> {
            // Send a string foo
            // producer.publish("foo", notificationConfig.getInternalExchange(), notificationConfig.getInternalNotificationRoutingKey());

            // send a data structure
            producer.publish(new Person("Ali", 18), notificationConfig.getInternalExchange(), notificationConfig.getInternalNotificationRoutingKey());
        };

    }
     */

    /**
     * test a data structure
     */
    record Person(String name, int age)
    {

    }
}
