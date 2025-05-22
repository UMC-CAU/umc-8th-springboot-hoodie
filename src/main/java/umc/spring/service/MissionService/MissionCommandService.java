package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.domain.Missions;
import umc.spring.domain.mapping.matchMissions;
import umc.spring.web.dto.MissionRequestDTO;

@Service
public interface MissionCommandService {

    Missions createMission(MissionRequestDTO.Create dto);

    matchMissions matchMission(MissionRequestDTO.Update dto);
}

