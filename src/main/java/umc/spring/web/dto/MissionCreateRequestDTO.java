package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.spring.validation.annotation.ExistCategories;

import java.util.List;

@Getter
public class MissionCreateRequestDTO {

    private Long storeId;
    private String content;
    private int point;
    private String missionSpec;
}
