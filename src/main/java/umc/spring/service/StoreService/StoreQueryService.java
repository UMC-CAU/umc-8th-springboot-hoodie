package umc.spring.service.StoreService;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import umc.spring.domain.Missions;
import umc.spring.domain.ReviewPost;
import umc.spring.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
    Page<ReviewPost> getReviewList(Long StoreId, Integer page);

    Page<Missions> getMissionList(Long MissionId,Integer page);
}