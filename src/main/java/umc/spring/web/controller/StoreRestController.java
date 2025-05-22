package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.StoreConverter;
import umc.spring.converter.UserConverter;
import umc.spring.domain.Store;
import umc.spring.service.StoreService.StoreCommandServiceImpl;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores/create")
public class StoreRestController {

    private final StoreCommandServiceImpl storeCommandServiceImpl;

    @PostMapping
    public ApiResponse<StoreResponseDTO.addStoreResultDTO> createStore(
            @RequestBody @Valid StoreRequestDTO.CreateDTO dto)
    {
        Store store = storeCommandServiceImpl.createStore(dto);
        return ApiResponse.onSuccess(StoreConverter.toStoreResultDTO(store));
    }
}
