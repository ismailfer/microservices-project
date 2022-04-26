package com.ismail.notification;

import com.ismail.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService
{
    private final NotificationRepository notificationRepository;


    public void sendNotification(NotificationRequest notificationRequest)
    {


        Notification notification = Notification.builder()
                .toCustomerId(notificationRequest.toCustomerId())
                .toCustomerEmail(notificationRequest.toCustomerEmail())
                .sender("microservices")
                .message(notificationRequest.message())
                .sentAt(LocalDateTime.now())
                .build();

        // save to db
        notificationRepository.save(notification);

    }
}
