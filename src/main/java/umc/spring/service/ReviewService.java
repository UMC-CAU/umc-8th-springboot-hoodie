package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
public class ReviewService {

    private final ReviewPostRepository reviewPostRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;

    public Long createReview(ReviewRequestDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));
        Store store = storeRepository.findById(dto.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("해당 가게가 존재하지 않습니다."));

        ReviewPost review = ReviewConverter.toReview(dto, user, store);
        return reviewPostRepository.save(review).getId();
    }
}
