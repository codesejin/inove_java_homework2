package com.sparta.springbeginner.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@MappedSuperclass// 상속했을때 칼럼으로 인식
@EntityListeners(AutoCloseable.class)// 생성/수정 시간을 자동으로 변경
@Getter
public class BlogMainDto{
    @Id
    private final Long id;
    private final String title;
    private final String username;
    private final LocalDateTime createdAt;
}
