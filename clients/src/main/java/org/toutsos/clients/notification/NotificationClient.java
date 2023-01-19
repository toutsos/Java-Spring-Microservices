package org.toutsos.clients.notification;

import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.*;

@FeignClient("notification")
public interface NotificationClient {
    @PostMapping("/api/v1/notification")
    void sendNotification (@RequestBody NotificationRequest request);
}
