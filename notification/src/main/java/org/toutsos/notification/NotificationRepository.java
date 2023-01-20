package org.toutsos.notification;

import org.springframework.data.jpa.repository.*;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
