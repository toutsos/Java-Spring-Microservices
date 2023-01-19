package org.toutsos.clients.notification;

import java.time.*;

public record NotificationRequest(
        Integer customerId,
        String message,
        String customerEmail
        ) {
}
