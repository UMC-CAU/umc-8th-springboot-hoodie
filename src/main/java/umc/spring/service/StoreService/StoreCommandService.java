package umc.spring.service.StoreService;

import org.springframework.stereotype.Service;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;

@Service
public interface StoreCommandService {

    Store createStore(StoreRequestDTO.CreateDTO dto);
}
