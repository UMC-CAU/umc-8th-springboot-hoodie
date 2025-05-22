package umc.spring.converter;

import org.springframework.stereotype.Component;
import umc.spring.domain.ReviewPost;
import umc.spring.domain.Store;
import umc.spring.domain.User;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

@Component
public class ReviewConverter {

    public static ReviewPost toReview(ReviewRequestDTO.AddDTO dto, User user) {
        return ReviewPost.builder()
                .user(user)
                .score(dto.getScore())
                .content(dto.getContent())
                .build();
    }

    public static ReviewResponseDTO.addReviewResultDTO toAddReviewResultDTO(ReviewPost review, User user) {
        return ReviewResponseDTO.addReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

}
