package umc.spring.web.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;

public class StoreRequestDTO {
    @Getter
    public static class CreateDTO {

        @NotNull
        String name;

        String description;

        double latitude;

        double longitude;
        @NotBlank
        String address;  // 예: "서울특별시 강남구 ..."

        //시간 형식은 HH:mm (예: 15:30)이어야 합니다.
        @Pattern(regexp = "^([01]\\d|2[0-3]):[0-5]\\d$")
        String openTime;
        @Pattern(regexp = "^([01]\\d|2[0-3]):[0-5]\\d$")
        String closeTime;

        @Max(4)
        @Min(1)
        Integer storeStatus;

        @Positive
        Integer foodCategory;
    }

}

