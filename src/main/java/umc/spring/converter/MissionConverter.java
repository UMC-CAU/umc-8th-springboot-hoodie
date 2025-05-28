package umc.spring.converter;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import umc.spring.domain.Missions;
import umc.spring.domain.Store;
import umc.spring.domain.User;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.matchMissions;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public static MissionResponseDTO.MatchMissionResultDTO matchMissionDTO(matchMissions matchMission) {
        return MissionResponseDTO.MatchMissionResultDTO.builder()
                .matchMissionId(matchMission.getId())
                .storeName(matchMission.getMissions().getStore().getName())
                .missionId(matchMission.getMissions().getId())
                .missionContent(matchMission.getMissions().getContent())
                .missionPoint(matchMission.getMissions().getPoint())
                .build();
    }

    public static MissionResponseDTO.MatchMissionResultListDTO matchMissionListDTO(Page<matchMissions> matchMissionList) {
        // 1. 요소는 MatchMissionResultDTO로 변환해야 함
        List<MissionResponseDTO.MatchMissionResultDTO> matchMissionDTOList = matchMissionList.stream()
                .map(MissionConverter::matchMissionDTO)
                .collect(Collectors.toList());

        // 2. MatchMissionResultListDTO는 이 리스트를 포함하는 바깥 DTO
        return MissionResponseDTO.MatchMissionResultListDTO.builder()
                .isLast(matchMissionList.isLast())
                .isFirst(matchMissionList.isFirst())
                .totalPage(matchMissionList.getTotalPages())
                .totalElements(matchMissionList.getTotalElements())
                .listSize(matchMissionDTOList.size())
                .matchMissionList(matchMissionDTOList)
                .build();
    }



}
