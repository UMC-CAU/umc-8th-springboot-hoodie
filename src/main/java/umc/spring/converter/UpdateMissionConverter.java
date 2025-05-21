package umc.spring.converter;

import org.springframework.stereotype.Component;
import umc.spring.domain.Missions;
import umc.spring.domain.User;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.matchMissions;

import java.time.LocalDateTime;

@Component
public class UpdateMissionConverter {

    public matchMissions toUpdateMission(User user, Missions mission) {
        return matchMissions.builder()
                .user(user)
                .missions(mission)
                .missionStatus(MissionStatus.ONGOING)
                .build();
    }
}

