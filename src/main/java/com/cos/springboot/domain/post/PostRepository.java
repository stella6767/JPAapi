package com.cos.springboot.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository  내부적으로 걸려있어서 생략가능
public interface PostRepository extends JpaRepository<Post,Integer> { //post 테이블에 관련된 DAO를 만들어달라

}
