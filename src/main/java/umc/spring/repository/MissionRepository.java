package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Missions;
import umc.spring.domain.Store;
import umc.spring.domain.enums.MissionStatus;

public interface MissionRepository extends JpaRepository<Missions, Long> {

    Page<Missions> findAllByStore(Store store, PageRequest pageRequest);

}
