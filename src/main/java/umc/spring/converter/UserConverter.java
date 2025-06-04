package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Missions;
import umc.spring.domain.User;
import umc.spring.domain.UserAddress;
import umc.spring.domain.enums.Gender;
import umc.spring.web.dto.StoreResponseDTO;
import umc.spring.web.dto.UserRequestDTO;
import umc.spring.web.dto.UserResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserConverter {

    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user) {
        return UserResponseDTO.JoinResultDTO.builder()
                .memberId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static User toUser(UserRequestDTO.JoinDto request) {

        Gender gender = null;

        if (request.getGender() == null) {
            throw new IllegalArgumentException("성별 값이 null입니다.");
        }

        switch (request.getGender()) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        LocalDate birthDate = LocalDate.of(
                request.getBirthYear(),
                request.getBirthMonth(),
                request.getBirthDay()
        );//정수형으로 받은 생일 LocalDate 타입으로 바꿔주기


        return User.builder()
                .userAddress(
                        UserAddress.builder()
                                .name(request.getAddress())
                                .build())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .matchCategoryList(new ArrayList<>())
                .birthday(birthDate)
                .email(request.getEmail())   // 추가된 코드
                .password(request.getPassword())   // 추가된 코드
                .role(request.getRole())   // 추가된 코드
                .build();
    }

    public static UserResponseDTO.LoginResultDTO toLoginResultDTO(Long memberId, String accessToken) {
        return UserResponseDTO.LoginResultDTO.builder()
                .memberId(memberId)
                .accessToken(accessToken)
                .build();
    }

    public static UserResponseDTO.UserInfoDTO toMemberInfoDTO(User user){
        return UserResponseDTO.UserInfoDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .gender(user.getGender().name())
                .build();
    }



}