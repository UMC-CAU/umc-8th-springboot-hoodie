package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Store;
import umc.spring.domain.StoreLocation;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.repository.StoreRepository.StoreLocationRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.web.dto.StoreCreateRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandService {

    private final StoreRepository storeRepository;
    private final StoreLocationRepository storeLocationRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    public Long createStore(StoreCreateRequestDTO dto) {
        StoreLocation location = storeLocationRepository.findByName(dto.getAddress())
                .orElseThrow(() -> new IllegalArgumentException("해당 주소에 대한 지역 정보가 없습니다."));

        FoodCategory category = foodCategoryRepository.findById(Long.valueOf(dto.getFoodCategory()))
                .orElseThrow(() -> new IllegalArgumentException("해당 음식 카테고리가 존재하지 않습니다."));

        Store store = StoreConverter.toStore(dto, location, category);
        return storeRepository.save(store).getId();
    }
}
