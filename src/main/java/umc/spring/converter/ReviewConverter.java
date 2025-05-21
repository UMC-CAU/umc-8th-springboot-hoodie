package umc.spring.converter;

import org.springframework.stereotype.Component;
import umc.spring.domain.ReviewPost;
import umc.spring.domain.Store;
import umc.spring.domain.User;
import umc.spring.web.dto.ReviewRequestDTO;

import java.time.LocalDateTime;

@Component
public class ReviewConverter {

    public static ReviewPost toReview(ReviewRequestDTO dto, User user, Store store) {
        return ReviewPost.builder()
                .user(user)
                .store(store)
                .score(dto.getScore())
                .content(dto.getContent())
                .build();
    }
}
