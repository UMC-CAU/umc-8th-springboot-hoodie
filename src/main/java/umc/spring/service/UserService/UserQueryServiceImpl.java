package umc.spring.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.apiPayload.exception.handler.UserHandler;
import umc.spring.config.security.jwt.JwtTokenProvider;
import umc.spring.converter.UserConverter;
import umc.spring.domain.Missions;
import umc.spring.domain.Store;
import umc.spring.domain.User;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.matchMissions;
import umc.spring.repository.MatchMissionRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.UserRepository.UserRepository;
import umc.spring.web.dto.UserResponseDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserQueryServiceImpl implements UserQueryService{

    private final MatchMissionRepository matchMissionRepository;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;


    @Override
    @Transactional
    public Page<matchMissions> getOngoingMissionList(Long userId, Integer page){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));

        Page<matchMissions> matchMissionsPage
                = matchMissionRepository.findAllByUserAndMissionStatus(user, MissionStatus.ONGOING ,PageRequest.of(page-1,10));
        return matchMissionsPage;
    }

    @Override
    @Transactional
    public Page<matchMissions> getDoneMissionList(Long userId, Integer page){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));

        Page<matchMissions> matchMissionsPage
                = matchMissionRepository.findAllByUserAndMissionStatus(user, MissionStatus.DONE ,PageRequest.of(page-1,10));
        return matchMissionsPage;
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponseDTO.UserInfoDTO getMemberInfo(HttpServletRequest request){
        Authentication authentication = jwtTokenProvider.extractAuthentication(request);
        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(()-> new UserHandler(ErrorStatus.USER_NOT_FOUND));
        return UserConverter.toMemberInfoDTO(user);
    }
}
