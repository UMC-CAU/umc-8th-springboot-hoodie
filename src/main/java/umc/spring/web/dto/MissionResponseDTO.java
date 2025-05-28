package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.enums.MissionStatus;

import java.time.LocalDateTime;
import java.util.List;

public class MissionResponseDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class creatResultDTO {
        private Long missionId;
        private String content;
        private int point;
        private String storeName;
        private LocalDateTime createdAt;
    }
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class MatchMissionResultDTO {
        private Long matchMissionId;
        private Long userId;
        private Long missionId;
        private String missionContent;
        private Integer missionPoint;
        private String storeName;
        private MissionStatus status;
        private LocalDateTime startedAt;
        private LocalDateTime createdAt;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class MatchMissionResultListDTO{
        List<MissionResponseDTO.MatchMissionResultDTO> matchMissionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }


}
