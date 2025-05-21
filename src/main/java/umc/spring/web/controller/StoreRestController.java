package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.service.StoreService.StoreCommandService;
import umc.spring.web.dto.StoreCreateRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping
    public ResponseEntity<Long> createStore(@RequestBody @Valid StoreCreateRequestDTO dto) {
        Long storeId = storeCommandService.createStore(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(storeId);
    }
}
