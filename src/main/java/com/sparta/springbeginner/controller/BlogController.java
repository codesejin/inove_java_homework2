package com.sparta.springbeginner.controller;

import com.sparta.springbeginner.service.BlogService;
import com.sparta.springbeginner.domain.Blog;
import com.sparta.springbeginner.domain.BlogMainDto;
import com.sparta.springbeginner.domain.BlogRepository;
import com.sparta.springbeginner.domain.BlogRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class BlogController {
    private final BlogService blogService;
    private final BlogRepository blogRepository;

    // 생성하기
    @PostMapping("/api/blogs")
    public Blog creatBlog(@RequestBody BlogRequestDto requestDto){
        return blogService.create(requestDto);
    }
    // 조회하기
    @GetMapping("/api/blogs")
    public List<BlogMainDto> readBlog() {
        return blogService.readMain();
    }

    //게시글 한개 조회
    @GetMapping("/api/blogs/{id}")
    public Blog readOneBlog (@PathVariable Long id) {
        return blogService.readOne(id);
    }

    //수정하기
    @PutMapping("/api/blogs/{id}")
    public Long updateBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto){
        blogService.update(id, requestDto);
        return id;
    }

    //삭제하기
    @DeleteMapping("/api/blogs/{id}")
    public Long deleteBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto){
        blogService.delete(id, requestDto);
        return id;
    }
}
