package umc.spring.service.UserService;

import jakarta.transaction.Transactional;
import umc.spring.domain.User;
import umc.spring.web.dto.UserRequestDTO;
import umc.spring.web.dto.UserResponseDTO;

public interface UserCommandService {
    @Transactional
    User joinUser(UserRequestDTO.JoinDto request);

    UserResponseDTO.LoginResultDTO loginMember(UserRequestDTO.LoginRequestDTO request);

}
