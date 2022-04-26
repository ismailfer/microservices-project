package com.ismail.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Notification
{
    @Id
    @SequenceGenerator(name = "notification_id_seq", sequenceName = "notification_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_id_seq")
    private Integer notificationId;

    private Integer toCustomerId;

    private String toCustomerEmail;

    private String sender;

    private String message;

    private LocalDateTime sentAt;
}
