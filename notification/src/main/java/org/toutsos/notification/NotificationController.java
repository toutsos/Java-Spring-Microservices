package org.toutsos.notification;

import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.web.bind.annotation.*;
import org.toutsos.clients.notification.*;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/api/v1/notification")
public class NotificationController {

    private NotificationService notificationService;

    @PostMapping
    public void sendNotification (@RequestBody NotificationRequest request) {
        log.info("New Notification... {}", request);
        notificationService.send(request);
    }

}
