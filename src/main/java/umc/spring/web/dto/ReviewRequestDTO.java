package umc.spring.web.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.validation.annotation.ExistCategories;

import java.time.LocalDate;
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
