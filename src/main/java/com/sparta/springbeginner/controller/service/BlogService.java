package com.sparta.springbeginner.controller.service;

import com.sparta.springbeginner.domain.Blog;
import com.sparta.springbeginner.domain.BlogRepository;
import com.sparta.springbeginner.domain.BlogRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BlogService{

    private final BlogRepository blogRepository;
    //서비스 로직에따라.
    @Transactional// 업데이트 할때 DB에반영 되어야 한다고 말해줌
    public  Boolean update(Long id, BlogRequestDto requestDto){
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if(blog.getPassword() != requestDto.getPassword()){
            System.out.println("비밀번호가 일치하지 않습니다.");
            return false;
        } else {
            System.out.println("수정 완료!");
            blog.update(requestDto);
            return true;
        }
    }

    @Transactional// 업데이트 할때 DB에반영 되어야 한다고 말해줌
    public  Boolean delete(Long id, BlogRequestDto requestDto){
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if(blog.getPassword() != requestDto.getPassword()){
            System.out.println("비밀번호가 일치하지 않습니다.");
            return false;
        } else {
            System.out.println("삭제 완료!");
            blog.delete(requestDto);
            return true;
        }
    }

//    @Transactional
//    public  Long update(Long id, BlogRequestDto requestDto){
//        Blog blog = blogRepository.findById(id).orElseThrow(
//                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
//        );
//        blog.update(requestDto);
//        return blog.getId();
//    }
    //생성하기
    @Transactional
    public Blog create(BlogRequestDto requestDto){
        Blog blog = new Blog(requestDto);
        blogRepository.save(blog);
        return blog;
    }
    //전체 조회하기
    @Transactional
    public List<Blog> read(){
        return blogRepository.findAllByOrderByModifiedAtDesc();
    }

    //하나 조회하기
    @Transactional
    public Optional<Blog> readOne(Long id){
        return blogRepository.findById(id);
    }

    // 일치하는지 여부 판단 ..수정..오류메세지 // 암호화 복화화..
    // 컨트롤러에서dto넘기고,업데이트하면 서비스에서 일치하면 수정하고, 아닐경우 리턴 에러..트랜젝션으로
}
