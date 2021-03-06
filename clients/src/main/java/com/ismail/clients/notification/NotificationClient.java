package com.ismail.clients.notification;

import com.ismail.clients.fraud.FraudCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


//@FeignClient("NOTIFICATION")
//@FeignClient(name = "notification") // works for eureka
@FeignClient(name = "notification", url = "${clients.notification.url}") // used for k8s service discovery
public interface NotificationClient
{
    @PostMapping(path = "api/v1/notification")
    void sendNotification(NotificationRequest notificationRequest);

}
