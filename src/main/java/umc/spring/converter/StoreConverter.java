package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.*;
import umc.spring.domain.enums.StoreStatus;
import umc.spring.web.dto.ReviewResponseDTO;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

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

    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(ReviewPost review){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getUser().getName())
                .score(Float.valueOf(review.getScore()))
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getContent())
                .build();
    }
    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<ReviewPost> reviewList){

        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    public static StoreResponseDTO.MissionViewDTO missionViewDTO(Missions missions){
        return StoreResponseDTO.MissionViewDTO.builder()
                .MissionId(missions.getId())
                .point(missions.getPoint())
                .content(missions.getContent())
                .missionSpec(missions.getMission_spec())
                .build();
    }

    public static StoreResponseDTO.MissionViewListDTO missionViewListDTO(Page<Missions> missionList){
        List<StoreResponseDTO.MissionViewDTO> missionViewDTOList = missionList.stream()
                .map(StoreConverter::missionViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.MissionViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionViewDTOList.size())
                .missionList(missionViewDTOList)
                .build();
    }

}




