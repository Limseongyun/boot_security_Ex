package com.example.demo.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.SawonDTO;
import com.example.demo.service.SawonService;

@Controller
public class Logincontroller {
	@Autowired
	private SawonService sawonservice;
	
	//메인페이지
	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
	//회원가입페이지
	@GetMapping("/user/join")
	public String join() {
		return"join";
	}
	//회원가입처리
	@PostMapping("/user/join")
	public String execjoin(SawonDTO sawondto) {
		sawonservice.join(sawondto);
		return"redirect:/user/login";
	}
	
	//로그페이지
	@GetMapping("/user/login")
	public String login() {
		return "login";
	}
	// 로그인 결과 페이지
    @GetMapping("/user/login/result")
    public String dispLoginResult(Principal principal,HttpSession session,HttpServletRequest req) {
    	System.out.println(principal.getName());
    	  
    	System.out.println(session.getAttribute(principal.getName()));
    	List<GrantedAuthority> authorities = new ArrayList<>();
    	for (GrantedAuthority e : authorities) {
    		System.out.println(e.getAuthority());
    		
    	}
    	
    	
    	
        return "loginSuccess";
    }
	//로그아웃 결과 페이지
	@GetMapping("/user/logout/result")
	public String logout() {
		return "logout";
	}
	//접근 거부 페이지
	@GetMapping("/user/denied")
	public String denied() {
		return"denied";
	}
	//어드민페이지
	@GetMapping("/admin/info")
	public String admin() {
		return"adminmenu";
	}
	//멤버페이지
	@GetMapping("/member/info")
	public String member() {
		return"membermenu";
	}
	//유저페이지
	@GetMapping("/user/info")
	public String user() {
		return"usermenu";
	}
}
