package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.spring.validation.annotation.ExistCategories;

import java.util.List;

@Getter
public class ReviewRequestDTO {

    private Long userId;
    private Long storeId;
    private Integer score;
    private String content;
}
