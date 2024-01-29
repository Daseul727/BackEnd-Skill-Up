package com.example.main.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    /**
     * post를 id로 조회
     * @param id
     * @return Post entity
     */
    Post findById(long id);
}
