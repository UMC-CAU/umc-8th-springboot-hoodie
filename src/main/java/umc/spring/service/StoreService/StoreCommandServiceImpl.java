package umc.spring.service.StoreService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.apiPayload.exception.handler.LocationHandler;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Store;
import umc.spring.domain.StoreLocation;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.repository.StoreRepository.StoreLocationRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;
    private final StoreLocationRepository storeLocationRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Store createStore(StoreRequestDTO.CreateDTO dto) {
        StoreLocation location = storeLocationRepository.findByName(dto.getAddress())
                .orElseThrow(() -> new LocationHandler(ErrorStatus.LOCATION_NOT_FOUND));

        FoodCategory category = foodCategoryRepository.findById(Long.valueOf(dto.getFoodCategory()))
                .orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));

        Store store = StoreConverter.toStore(dto, location, category);
        return storeRepository.save(store);
    }
}
