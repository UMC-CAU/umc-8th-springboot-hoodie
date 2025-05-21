package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.UpdateMissionConverter;
import umc.spring.domain.Missions;
import umc.spring.domain.User;
import umc.spring.domain.mapping.matchMissions;
import umc.spring.repository.MatchMissionRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.UserRepository.UserRepository;
import umc.spring.web.dto.UpdateMissionRequestDTO;

@Service
@RequiredArgsConstructor
public class UpdateMissionService {

    private final UserRepository userRepository;
    private final MissionRepository missionRepository;
    private final MatchMissionRepository matchMissionRepository;
    private final UpdateMissionConverter converter;

    public Long matchMission(UpdateMissionRequestDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));

        Missions mission = missionRepository.findById(dto.getMissionId())
                .orElseThrow(() -> new IllegalArgumentException("해당 미션이 존재하지 않습니다."));

        matchMissions match = converter.toUpdateMission(user, mission);
        return matchMissionRepository.save(match).getId();
    }
}
