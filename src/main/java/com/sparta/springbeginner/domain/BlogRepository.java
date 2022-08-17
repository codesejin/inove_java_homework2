package com.sparta.springbeginner.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;
@EnableJpaAuditing // -> GET 405 메소드 에러 뜰때 꼭 있어야함
public interface BlogRepository extends JpaRepository <Blog, Long> {
    List<Blog> findAllByOrderByModifiedAtDesc();
}
