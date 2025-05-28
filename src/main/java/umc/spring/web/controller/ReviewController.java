package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.converter.UserConverter;
import umc.spring.domain.ReviewPost;
import umc.spring.domain.User;
import umc.spring.service.ReviewCommandService;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;
import umc.spring.web.dto.UserRequestDTO;
import umc.spring.web.dto.UserResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewCommandService reviewService;

    @PostMapping
    public ApiResponse<ReviewResponseDTO.addReviewResultDTO> createReview(
            @RequestBody @Valid ReviewRequestDTO.AddDTO dto)
    {
        ReviewPost review = reviewService.createReview(dto);
        User user = review.getUser();  // converter 파라미터 필요 시

        return ApiResponse.onSuccess(ReviewConverter.toAddReviewResultDTO(review, user));
    }



}

