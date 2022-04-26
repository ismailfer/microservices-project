package com.ismail.customer;

import com.ismail.clients.fraud.FraudCheckResponse;
import com.ismail.clients.fraud.FraudClient;
import com.ismail.clients.notification.NotificationClient;
import com.ismail.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService
{
    private final CustomerRepository customerRepository;

    //private final RestTemplate restTemplate;

    private final FraudClient fraudClient;

    private final NotificationClient notificationClient;

    public void registerCustomer(CustomerRegistrationRequest request)
    {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        // todo validate email
        // todo check if email not taken


        customerRepository.saveAndFlush(customer);



        // check if fraud

        /* RestAPI call Using hard coded server:port
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://localhost:18081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId());
        */

        /* RestAPI call Using Eureka
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId());
        */

        // RestAPI call Using OpenFeign
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster())
        {
            throw new IllegalStateException("Fraudster");
        }

        // Send notification - Using OpenFeign

        NotificationRequest notifyRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to Microservices!", customer.getFirstName()));

        notificationClient.sendNotification(notifyRequest);

        // TODO: send notification using a queue


    }
}
