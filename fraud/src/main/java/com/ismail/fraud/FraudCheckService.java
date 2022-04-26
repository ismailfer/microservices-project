package com.ismail.fraud;

import com.ismail.clients.notification.NotificationClient;
import com.ismail.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService
{
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    //private final NotificationClient notificationClient;


    public boolean isFraudulentCustomer(Integer customerId)
    {
        // create a record

        FraudCheckHistory fcheck = FraudCheckHistory.builder()
                .customerId(customerId)
                .isFraudster(false)
                .createdAt(LocalDateTime.now())
                .build();

        fraudCheckHistoryRepository.save(fcheck);

        // todo: check if this customer is a fraud

        // send notification

        //NotificationRequest notifyRequest = new NotificationRequest(customerId, "fraud", "fraud history check");
        //notificationClient.submitNotificationRequest(notifyRequest);


        //
        return fcheck.getIsFraudster();
    }
}
