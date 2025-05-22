package umc.spring.web.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.spring.validation.annotation.ExistCategories;

import java.util.List;

@Getter
public class ReviewRequestDTO {

    @Getter
    public static class AddDTO{
        @NotNull
        Long userId;

        @NotNull
        Long storeId;

        @Min(0)
        Integer score;

        String content;
    }
}
