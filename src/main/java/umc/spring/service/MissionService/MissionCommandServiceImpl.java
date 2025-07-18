package umc.spring.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.apiPayload.exception.handler.UserHandler;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Missions;
import umc.spring.domain.Store;
import umc.spring.domain.User;
import umc.spring.domain.mapping.matchMissions;
import umc.spring.repository.MatchMissionRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.repository.UserRepository.UserRepository;
import umc.spring.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    private final UserRepository userRepository;
    private final MatchMissionRepository matchMissionRepository;

    @Transactional
    public Missions createMission(MissionRequestDTO.Create dto) {
        Store store = storeRepository.findById(dto.getStoreId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Missions mission = MissionConverter.toMission(dto, store);
        return missionRepository.save(mission);
    }

    @Transactional
    public matchMissions matchMission(MissionRequestDTO.Update dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));

        Missions mission = missionRepository.findById(dto.getMissionId())
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        matchMissions match = MissionConverter.toMatchMission(user, mission);
        return matchMissionRepository.save(match);
    }
}

