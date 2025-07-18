package umc.spring.domain.mapping;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Fetch;
import lombok.*;
import umc.spring.domain.BaseEntity;
import umc.spring.domain.Missions;
import umc.spring.domain.User;
import umc.spring.domain.enums.MissionStatus;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class matchMissions extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10) DEFAULT 'ACTIVE'")
    private MissionStatus missionStatus;

    private LocalDate deadline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Missions missions;
}
