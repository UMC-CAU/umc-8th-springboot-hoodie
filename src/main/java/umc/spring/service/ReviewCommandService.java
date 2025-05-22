package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.apiPayload.exception.handler.UserHandler;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.ReviewPost;
import umc.spring.domain.Store;
import umc.spring.domain.User;
import umc.spring.repository.ReviewPostRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.repository.UserRepository.UserRepository;
import umc.spring.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandService {

    private final ReviewPostRepository reviewPostRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;

    public ReviewPost createReview(ReviewRequestDTO.AddDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));
        Store store = storeRepository.findById(dto.getStoreId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        ReviewPost review = ReviewConverter.toReview(dto, user);

        // 연관관계 설정 (양방향 유지)
        review.setStore(store);

        return reviewPostRepository.save(review);
    }
}
