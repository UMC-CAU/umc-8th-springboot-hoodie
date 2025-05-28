package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.StoreConverter;
import umc.spring.converter.UserConverter;
import umc.spring.domain.Missions;
import umc.spring.domain.ReviewPost;
import umc.spring.domain.Store;
import umc.spring.service.StoreService.StoreCommandServiceImpl;
import umc.spring.service.StoreService.StoreQueryServiceImpl;
import umc.spring.validation.annotation.ValidPage;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandServiceImpl storeCommandServiceImpl;
    private final StoreQueryServiceImpl storeQueryServiceimpl;

    @GetMapping("/create")
    public ApiResponse<StoreResponseDTO.addStoreResultDTO> createStore(
            @RequestBody @Valid StoreRequestDTO.CreateDTO dto)
    {
        Store store = storeCommandServiceImpl.createStore(dto);
        return ApiResponse.onSuccess(StoreConverter.toStoreResultDTO(store));
    }

    @GetMapping("/{storeId}/reviews")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(
            @PathVariable(name = "storeId") Long storeId, @RequestParam(name = "page") @umc.spring.validation.annotation.convertPage @ValidPage Integer page){
        Page<ReviewPost> reviewList = storeQueryServiceimpl.getReviewList(storeId,page);
        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(reviewList));
    }

    @GetMapping("/{storeId}/missions")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "missionId", description = "미션의 아이디, path variable 입니다!")
    })
    public ApiResponse<StoreResponseDTO.MissionViewListDTO> getMissionList(
            @PathVariable(name = "storeId") Long storeId, @RequestParam(name = "page") @umc.spring.validation.annotation.convertPage @ValidPage Integer page){
        //PAGE 변환시키는 커스텀어노테이션(프론트에서 받은 페이지 번호 - 1),
        // 프론트에서 받은 페이지번호가 1이상인지 검증하는 커스텀어노테이션
        Page<Missions> missionList = storeQueryServiceimpl.getMissionList(storeId,page);
        return ApiResponse.onSuccess(StoreConverter.missionViewListDTO(missionList));
    }


}


