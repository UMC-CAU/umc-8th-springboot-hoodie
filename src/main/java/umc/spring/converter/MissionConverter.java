package umc.spring.converter;

import org.springframework.stereotype.Component;
import umc.spring.domain.Missions;
import umc.spring.domain.Store;
import umc.spring.web.dto.MissionCreateRequestDTO;

import java.time.LocalDateTime;

@Component
public class MissionConverter {

    public static Missions toMission(MissionCreateRequestDTO dto, Store store) {
        return Missions.builder()
                .store(store)
                .content(dto.getContent())
                .point(dto.getPoint())
                .mission_spec(dto.getMissionSpec())
                .build();
    }
}
