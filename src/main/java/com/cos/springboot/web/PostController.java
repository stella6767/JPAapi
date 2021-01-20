package com.cos.springboot.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.springboot.domain.post.Post;
import com.cos.springboot.service.PostService;

//http요청시에 @Controller, @RestController가 붙은 클래스가 메모리(IOC Container)에 로딩
@Controller
public class PostController {
	
	//PostService service = new PostService(); //요청시마다 컨트롤러는 뜨는데 얘는 한번만 뜨고 참조하면 된다..그래서 이렇게 안하고 싱글톤으로 한다.
	//스프링에서는 이미 제공하는 싱글톤 IOC 컨테이너를 사용하면 된다. 밑의 방식 DI
	
	private PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	
	
	//Model 객체 제공!!
	@GetMapping("/post")//HttpServletRequest request 
	public String findAll(Model model) { //컨트롤러의 함수의 파라메터는 톰캣이 가지고 있는 객체 + IOC컨테이너가 가지고 있는 객체
		//1.DB에 데이터 가져오기
		//2.request 값 담기
		List<Post> posts = postService.글목록();
		System.out.println(posts);
		//request.setAttribute("post", posts);
		model.addAttribute("posts",posts);  //Model이나 request나 똑같다..
		return "post/list";//3.RequestDispatcher 사용
	}
	
	
	@GetMapping("/post/{id}")
	public String findById(@PathVariable int id, Model model) {
		
		model.addAttribute("post",postService.글상세보기(id));
		return "post/detail";
	}
	
	
	@PostMapping("/post")
	public String save(Post post) { //x-www-form-urlencoded 타입을 매핑해서 변환..  JSON 으로 던지면 못 받음
		System.out.println("post: "+ post);
		postService.글저장(post);
	
		return "redirect:/post"; //response.sendRedirect-redirect 붙이면 sendredirect 발동..데이터를 들고, findAll로 감
	}
	
	
	
	
	
}
