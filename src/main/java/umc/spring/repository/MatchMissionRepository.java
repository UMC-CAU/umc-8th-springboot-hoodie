package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Missions;
import umc.spring.domain.User;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.matchMissions;

import java.util.List;

public interface MatchMissionRepository extends JpaRepository<matchMissions, Long> {

    Page<matchMissions> findAllByUserAndMissionStatus(User user, MissionStatus status, PageRequest pageRequest);
}
