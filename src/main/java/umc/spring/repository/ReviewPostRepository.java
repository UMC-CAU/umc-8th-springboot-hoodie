package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.ReviewPost;
import umc.spring.domain.Store;

public interface ReviewPostRepository extends JpaRepository<ReviewPost, Long> {

    Page<ReviewPost> findAllByStore(Store store, PageRequest pageRequest);
}