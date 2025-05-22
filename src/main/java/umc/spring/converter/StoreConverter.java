package umc.spring.converter;

import umc.spring.domain.FoodCategory;
import umc.spring.domain.Store;
import umc.spring.domain.StoreLocation;
import umc.spring.domain.enums.StoreStatus;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class StoreConverter {

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public static Store toStore(StoreRequestDTO.CreateDTO dto, StoreLocation location, FoodCategory category) {

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
                .storeLocation(location)
                .build();
    }
    public static StoreResponseDTO.addStoreResultDTO toStoreResultDTO(Store store) {
        return StoreResponseDTO.addStoreResultDTO.builder()
                .storeId(store.getId())
                .name(store.getName())
                .latitude(store.getLatitude())
                .longitude(store.getLongitude())
                .address(store.getAddress())
                .createdAt(LocalDateTime.now())
                .build();
    }

}




