package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

public class MissionRequestDTO {

    @Getter
    public static class Create {
        @NotNull
        private Long storeId;

        @NotBlank
        private String content;

        @Positive
        private int point;

        private String missionSpec;
    }

    @Getter
    public static class Update {
        @NotNull
        private Long userId;

        @NotNull
        private Long missionId;
    }
}
