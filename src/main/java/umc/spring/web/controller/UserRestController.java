package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.UserConverter;
import umc.spring.domain.User;
import umc.spring.domain.mapping.matchMissions;
import umc.spring.service.UserService.UserCommandService;
import umc.spring.service.UserService.UserCommandServiceImpl;
import umc.spring.service.UserService.UserQueryService;
import umc.spring.service.UserService.UserQueryServiceImpl;
import umc.spring.validation.annotation.ValidPage;
import umc.spring.web.dto.MissionResponseDTO;
import umc.spring.web.dto.UserRequestDTO;
import umc.spring.web.dto.UserResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Validated
public class UserRestController {

    private final UserCommandServiceImpl userCommandServiceImpl;
    private final UserQueryServiceImpl userQueryServiceImpl;

    @PostMapping("/")
    public ApiResponse<UserResponseDTO.JoinResultDTO> join(@RequestBody @Valid UserRequestDTO.JoinDto request){
        User user = userCommandServiceImpl.joinUser(request);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDTO(user));
    }

    @PostMapping("/{userId}/ongoingMissions")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "userId", description = "user 아이디, path variable 입니다!")
    })
    public ApiResponse<MissionResponseDTO.MatchMissionResultListDTO> getOngoingMissions(
            @PathVariable(name = "userId") Long userId,
            @RequestParam(name = "page") @umc.spring.validation.annotation.convertPage @ValidPage Integer page
    ) {
        Page<matchMissions> ongoingMissions = userQueryServiceImpl.getOngoingMissionList(userId, page);

        return ApiResponse.onSuccess(MissionConverter.matchMissionListDTO(ongoingMissions));
    }

    @PostMapping("/{userId}/doneMissions")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "userId", description = "user의 아이디, path variable 입니다!")
    })
    public ApiResponse<MissionResponseDTO.MatchMissionResultListDTO> getDoneMissions(
            @PathVariable(name = "userId") Long userId,
            @RequestParam(name = "page") @ValidPage Integer page
    ) {
        Page<matchMissions> doneMissions = userQueryServiceImpl.getDoneMissionList(userId, page);

        return ApiResponse.onSuccess(MissionConverter.matchMissionListDTO(doneMissions));
    }

}
