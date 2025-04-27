package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class RequestReview extends BaseEntity {
    @Id
    private Long requestId;

    @ManyToOne
    @JoinColumn(name = "notification_id")
    private Notification notification;

    @Column(columnDefinition = "VARCHAR(30) DEFAULT 'ACTIVE'")
    private String title;

    @Column(columnDefinition = "VARCHAR(100) DEFAULT 'ACTIVE'")
    private String body;
}
