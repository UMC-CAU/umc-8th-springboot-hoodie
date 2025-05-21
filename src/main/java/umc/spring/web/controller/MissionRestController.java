package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.service.MissionService;
import umc.spring.web.dto.MissionCreateRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionService missionService;

    @PostMapping
    public ResponseEntity<Long> createMission(@RequestBody @Valid MissionCreateRequestDTO dto) {
        Long missionId = missionService.createMission(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(missionId);
    }
}
