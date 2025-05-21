package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.service.UpdateMissionService;
import umc.spring.web.dto.UpdateMissionRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/match-missions")
public class UpdateMissionController {

    private final UpdateMissionService updateMissionService;

    @PostMapping
    public ResponseEntity<Long> matchMission(@RequestBody @Valid UpdateMissionRequestDTO dto) {
        Long id = updateMissionService.matchMission(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }
}
