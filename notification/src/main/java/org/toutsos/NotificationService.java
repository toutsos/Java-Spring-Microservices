package org.toutsos;

import lombok.*;
import org.springframework.stereotype.*;
import org.toutsos.clients.notification.*;

import java.time.*;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public void send (NotificationRequest request) {
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(request.customerId())
                        .toCustomerEmail(request.customerEmail())
                        .sender("Angelos")
                        .message(request.message())
                        .sendAt(LocalDateTime.now())
                        .build()
        );

    }

}
