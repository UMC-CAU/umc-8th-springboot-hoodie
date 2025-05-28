package umc.spring.service.UserService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Missions;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.matchMissions;
import umc.spring.repository.MatchMissionRepository;
import umc.spring.web.dto.MissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public interface UserQueryService {
    Page<matchMissions> getOngoingMissionList(Long storeId, Integer page);

    Page<matchMissions> getDoneMissionList(Long storeId, Integer page);


}
