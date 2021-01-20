package com.cos.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cos.springboot.domain.post.Post;
import com.cos.springboot.domain.post.PostRepository;

//@Controller, @RestController, @Service, @Configuration, @Component(옆의 애들의 원형, 딱히 목적이 없는 객체를 띄울 때 사용)
@Service // 서버 실행시에 IOC 등록
public class PostService {

	private PostRepository postRepository;

	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

//	public PostService() {
//		System.out.println("postService 실행됨"); //서버 시작 시에 뜨는 것을 확인할 수 있다.
//	}

	public Post 글상세보기(int id) {
		return postRepository.findById(id).orElse(new Post()); // .get은 null 뜨더라도 무조건 가져온다..
	}

	public Post 글저장(Post post) {
		Post postEntity = postRepository.save(post);
		return postEntity; // 실제 DB에서 가지고 온 값의 객체를 엔티티라 한다..
	}

	public List<Post> 글목록() {
		return postRepository.findAll();
	}
}
