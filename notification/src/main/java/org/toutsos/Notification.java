package org.toutsos;

import lombok.*;

import javax.persistence.*;
import java.time.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Notification {
    @Id
    @SequenceGenerator(
            name = "notification_id_sequence",
            sequenceName = "notification_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "notification_id_sequence"
    )
    private Integer notificationId;
    private String message;
    private LocalDateTime sendAt;
    private Integer toCustomerId;
    private String toCustomerEmail;
    private String sender;

}
