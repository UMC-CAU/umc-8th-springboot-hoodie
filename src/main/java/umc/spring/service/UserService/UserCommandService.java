package umc.spring.service.UserService;

import jakarta.transaction.Transactional;
import umc.spring.domain.User;
import umc.spring.web.dto.UserRequestDTO;

public interface UserCommandService {
    @Transactional
    User joinUser(UserRequestDTO.JoinDto request);

}
