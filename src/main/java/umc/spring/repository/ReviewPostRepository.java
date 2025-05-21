package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.ReviewPost;

public interface ReviewPostRepository extends JpaRepository<ReviewPost, Long> {}