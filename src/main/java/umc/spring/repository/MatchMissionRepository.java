package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Missions;
import umc.spring.domain.mapping.matchMissions;

public interface MatchMissionRepository extends JpaRepository<matchMissions, Long> {
}
