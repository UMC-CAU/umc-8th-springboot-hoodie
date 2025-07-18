package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Missions;
import umc.spring.domain.Store;
import umc.spring.domain.User;
import umc.spring.domain.mapping.matchMissions;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;
import umc.spring.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
@Validated
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    //미션 생성
    @PostMapping("/create")
    public ApiResponse<MissionResponseDTO.creatResultDTO> createMission(
            @RequestBody @Valid MissionRequestDTO.Create dto)
    {
        Missions missions = missionCommandService.createMission(dto);
        Store store = missions.getStore();
        return ApiResponse.onSuccess(MissionConverter.toMissionCreateResultDTO(missions,store));
    }

    //미션 수행
    @PostMapping("/ongoing")
    public ApiResponse<MissionResponseDTO.MatchMissionResultDTO> matchMission(
            @RequestBody @Valid MissionRequestDTO.Update dto)
    {
        matchMissions matchMissions = missionCommandService.matchMission(dto);
        User user = matchMissions.getUser();
        Missions missions = matchMissions.getMissions();
        return ApiResponse.onSuccess(MissionConverter.toMatchMissionResultDTO(matchMissions,user,missions));
    }
}
