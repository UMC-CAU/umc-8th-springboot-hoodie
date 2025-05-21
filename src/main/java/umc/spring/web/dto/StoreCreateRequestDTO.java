package umc.spring.web.dto;

import jakarta.persistence.*;
import lombok.Getter;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.ReviewPost;
import umc.spring.domain.StoreLocation;
import umc.spring.domain.enums.StoreStatus;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class StoreCreateRequestDTO {
    private String name;
    private String description;
    private double latitude;
    private double longitude;
    private String address;  // 예: "서울특별시 강남구 ..."

    private String openTime;
    private String closeTime;

    private Integer storeStatus;

    private Integer foodCategory;

}

