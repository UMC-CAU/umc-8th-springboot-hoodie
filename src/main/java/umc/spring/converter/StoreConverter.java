package umc.spring.converter;

import umc.spring.domain.FoodCategory;
import umc.spring.domain.Store;
import umc.spring.domain.StoreLocation;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.enums.StoreStatus;
import umc.spring.web.dto.StoreCreateRequestDTO;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class StoreConverter {

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public static Store toStore(StoreCreateRequestDTO dto, StoreLocation location, FoodCategory category) {

        StoreStatus storeStatus = null;

        switch (dto.getStoreStatus()){
            case 1:
                storeStatus = StoreStatus.CLOSE;
                break;
            case 2:
                storeStatus = StoreStatus.OPEN;
                break;
            case 3:
                storeStatus = StoreStatus.NONE;
                break;
        }
        return Store.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .address(dto.getAddress())
                .openTime(LocalTime.parse(dto.getOpenTime()))
                .closeTime(LocalTime.parse(dto.getCloseTime()))
                .storeStatus(storeStatus)
                .category(category)
                .build();
    }
}




