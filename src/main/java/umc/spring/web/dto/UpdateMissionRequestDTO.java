package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UpdateMissionRequestDTO {

    @NotNull
    private Long userId;

    @NotNull
    private Long missionId;
}

