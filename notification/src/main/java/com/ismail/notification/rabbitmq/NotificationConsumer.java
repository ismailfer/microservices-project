package com.ismail.notification.rabbitmq;

import com.ismail.clients.notification.NotificationRequest;
import com.ismail.notification.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationConsumer
{
    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotificationRequest notificationRequest)
    {
        log.info("Consumed [{}] from queue", notificationRequest);

        notificationService.sendNotification(notificationRequest);
    }
}
