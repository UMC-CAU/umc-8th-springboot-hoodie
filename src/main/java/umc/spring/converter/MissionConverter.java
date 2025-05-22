package umc.spring.converter;

import org.springframework.stereotype.Component;
import umc.spring.domain.Missions;
import umc.spring.domain.Store;
import umc.spring.domain.User;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.matchMissions;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

@Component
public class MissionConverter {

    public static Missions toMission(MissionRequestDTO.Create dto, Store store) {
        return Missions.builder()
                .store(store)
                .content(dto.getContent())
                .point(dto.getPoint())
                .mission_spec(dto.getMissionSpec())
                .build();
    }

    public static matchMissions toMatchMission(User user, Missions mission) {
        return matchMissions.builder()
                .user(user)
                .missions(mission)
                .missionStatus(MissionStatus.ONGOING)
                .build();
    }
    public static MissionResponseDTO.creatResultDTO toMissionCreateResultDTO(Missions mission, Store store) {
        return MissionResponseDTO.creatResultDTO.builder()
                .missionId(mission.getId())
                .content(mission.getContent())
                .point(mission.getPoint())
                .storeName(store.getName())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static MissionResponseDTO.MatchMissionResultDTO toMatchMissionResultDTO(matchMissions match, User user, Missions mission) {
        return MissionResponseDTO.MatchMissionResultDTO.builder()
                .matchMissionId(match.getId())
                .userId(user.getId())
                .missionId(mission.getId())
                .missionContent(mission.getContent())
                .missionPoint(mission.getPoint())
                .status(match.getMissionStatus())
                .createdAt(LocalDateTime.now())
                .build();
    }


}
