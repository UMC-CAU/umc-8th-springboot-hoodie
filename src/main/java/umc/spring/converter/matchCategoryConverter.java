package umc.spring.converter;

import umc.spring.domain.FoodCategory;
import umc.spring.domain.User;
import umc.spring.domain.mapping.matchCategory;
import umc.spring.web.dto.UserRequestDTO;
import umc.spring.web.dto.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class matchCategoryConverter {
    public static List<matchCategory> toUserPreferList(List<FoodCategory> foodCategoryList) {
        return foodCategoryList.stream()
                .map(foodCategory ->
                        matchCategory.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }

}


